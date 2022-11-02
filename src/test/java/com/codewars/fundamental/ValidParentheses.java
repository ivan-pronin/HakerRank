package com.codewars.fundamental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * //TODO javadocs.
 *
 * @author Ivan Pronin
 * @since 02.11.2022
 */
public class ValidParentheses {

    public static boolean validParentheses(String parens)
    {
        String[] array = parens.split("");
        int sum = 0;
        for (String s : array){
            if (s.equals("(")) sum++;
            if (s.equals(")")) sum--;
            if (sum < 0) return false;
        }
        return sum == 0;
    }

    @Test
    public void sampleTest() {
        assertEquals(true,ValidParentheses.validParentheses( "()" ));
        assertEquals(false,ValidParentheses.validParentheses( "())" ));
        assertEquals(true,ValidParentheses.validParentheses( "32423(sgsdg)" ));
        assertEquals(false,ValidParentheses.validParentheses( "(dsgdsg))2432" ));
        assertEquals(true,ValidParentheses.validParentheses( "adasdasfa" ));
    }

    @Test
    public void fixedTests() {
        assertEquals(false,ValidParentheses.validParentheses( "()()((()" ));
        assertEquals(true,ValidParentheses.validParentheses( "()" ));
        assertEquals(true,ValidParentheses.validParentheses( "()()" ));
        assertEquals(true,ValidParentheses.validParentheses( "(())" ));
        assertEquals(false,ValidParentheses.validParentheses( ")" ));
        assertEquals(true,ValidParentheses.validParentheses( "" ));
        assertEquals(false,ValidParentheses.validParentheses( "())" ));
        assertEquals(true,ValidParentheses.validParentheses( "((((()))))" ));
        assertEquals(false,ValidParentheses.validParentheses( "()))" ));
        assertEquals(false,ValidParentheses.validParentheses( "()()()())" ));
        assertEquals(true,ValidParentheses.validParentheses( "(()()()())(())" ));
        assertEquals(false,ValidParentheses.validParentheses( "((((((((" ));
        assertEquals(true,ValidParentheses.validParentheses( "(())((()((()))))" ));
        assertEquals(false,ValidParentheses.validParentheses( "())(" ));
        assertEquals(false,ValidParentheses.validParentheses( ")()()()(" ));
        assertEquals(false,ValidParentheses.validParentheses( "(()()))(" ));
        assertEquals(false,ValidParentheses.validParentheses( ")()(" ));
        assertEquals(false,ValidParentheses.validParentheses( "())(()" ));
        assertEquals(false,ValidParentheses.validParentheses( "())(()" ));
        assertEquals(true,ValidParentheses.validParentheses( "wugwbguegb" ));
        assertEquals(false,ValidParentheses.validParentheses( "()SDGH#*)DDHGDFGHOHOSHG((fdfdughohg*$YGSg49)" ));
    }
    @Test
    public void randomTests()
    {
        List<Boolean>  ar = shuffle100();
        for(int i = 0 ; i < 100; i ++){
            String s = "";
            if(ar.get(i))
                s = generateTrue();
            else
                s = generateFail();
            assertEquals(ar.get(i),ValidParentheses.validParentheses(s));
        }
    }

    private String generateTrue()
    {
        int depth = 0;
        int initialLen = (int)(Math.random()*25) + 1;
        StringBuilder b = new StringBuilder();
        for(int i = 0 ; i < initialLen; i ++){
            double val = Math.random();
            if(depth >0 && val < 0.22)
            {
                depth--;
                b.append(')');
            }
            else if(val > 0.77)
            {
                b.append('(');
                depth++;
            }
            else
                b.append((char)((int)(Math.random()*83)+43));
        }
        for(int i = 0 ; i < depth; i ++)
        {
            int q = (int)(Math.random()*9);
            for(int j = 0 ; j < q; j++)
                b.append((char)((int)(Math.random()*83)+43));
            b.append(')');
        }
        int q = (int)(Math.random()*9);
        for(int j = 0 ; j < q; j++)
            b.append((char)((int)(Math.random()*83)+43));
        return b.toString();
    }

    private String generateFail()
    {
        int depth = 0;
        int initialLen = (int)(Math.random()*25) + 1;
        StringBuilder b = new StringBuilder();
        boolean f = false;
        for(int i = 0 ; i < initialLen; i ++){
            double val = Math.random();
            if(val < 0.22)
            {
                if(depth == 0)
                    f = true;
                depth--;
                b.append(')');
            }
            else if(val > 0.77)
            {
                b.append('(');
                depth++;
            }
            else
                b.append((char)((int)(Math.random()*83)+43));
        }
        if(depth == 0 && !f)
        {
            int q = (int)(Math.random()*9);
            for(int j = 0 ; j < q; j++)
                b.append((char)((int)(Math.random()*83)+43));
            if(q <4)
                b.append(')');
            else
                b.append('(');
        }
        double testBalancedbutOpen = Math.random();
        if(f && testBalancedbutOpen < 0.5)
        {
            for(int i = 0 ; i < depth ; i ++)
            {
                int q = (int)(Math.random()*9);
                for(int j = 0 ; j < q; j++)
                    b.append((char)((int)(Math.random()*83)+43));
                b.append('(');
            }
        }
        int r = (int)(Math.random()*9);
        for(int j = 0 ; j < r; j++)
            b.append((char)((int)(Math.random()*83)+43));
        return b.toString();
    }


    private List<Boolean> shuffle100()
    {
        List<Boolean>  ar = new ArrayList<Boolean>();
        for(int i = 0; i < 50; i ++ )
        {
            ar.add(false);
            ar.add(true);
        }
        Collections.shuffle(ar);
        return ar;
    }
}
