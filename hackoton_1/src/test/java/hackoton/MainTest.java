package hackoton;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public abstract class MainTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Main.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    @Parameterized.Parameter
    public String testString;


    String randomID() {
        Random random = new Random();
        return String.valueOf(random.nextInt(9)) + String.valueOf(random.nextInt(9)) + String.valueOf(random.nextInt(9)) + String.valueOf(random.nextInt(9));
    }


    public String getRandString() {

        Random random = new Random();
        int n = random.nextInt(100);
        StringBuilder bigRandString = new StringBuilder();

        bigRandString.append(n + "\n");


        for (int i = 0; i < n; i++) {

            int m = random.nextInt(100);
            bigRandString.append(randomID() + " ");
            bigRandString.append(m + " ");

            for (int j = 0; j < m - 1; j++)
                bigRandString.append(randomID() + " ");
            bigRandString.append(randomID() + "\n");
        }


        return bigRandString.toString();

    }


    @Parameterized.Parameters
    public List<String> data() {

        return Arrays.asList(
                "4\n" +
                        "4578 8 1256 1232 4323 1897 1897 3244 4572 5678\n" +
                        "1256 2 4578 1897\n" +
                        "4323 2 9766 9543\n" +
                        "9766 1 3624\n",
                getRandString(),
                getRandString(),
                getRandString(),
                getRandString()

        );
    }

    @Test
    public void test(){

    }
}
