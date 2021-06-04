import org.junit.Test;

public class test01 {

    @Test
    public void test01() {
        int[][] arr = new int[2][4];
        System.out.println(arr.length);

        int a = 10 / 3;
        System.out.println(a);

        int b = 10 % 3;
        System.out.println(b);


        System.out.println("循环");
    }



    @Test
    public void test02() {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    test03();
                }
                System.out.println("内部"+ j);
            }
            System.out.println("外部"+ i);

        }
    }

    public void test03(){
        return;
    }
}