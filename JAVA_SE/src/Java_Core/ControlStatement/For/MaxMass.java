package Java_Core.ControlStatement.For;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vitaliy on 04.03.2016.
 */
public class MaxMass

    {
        public static void main(String[] args) throws Exception
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int[] num = new int[10];
            String[] s = new String[10];

            for (int i = 0; i < s.length; i++)
            {
                s[i] = reader.readLine();
            }

            for (int i = 0; i < num.length; i++)
            {
                num[i] = s.length;
                System.out.println(num[i-1]);
            }

        }

}
