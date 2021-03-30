public class Main {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        arr1();
        arr2();

    }

    static void arr1() {
        float[] arr1 = new float[size];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Время расчета формулы в одном потоке: " + (System.currentTimeMillis() - a));
    }

    static void arr2() {
        float[] arr2 = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        Thread t1 = new Thread(new Arr2(){
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

            Thread t2 = new Thread(new Arr2() {
                @Override
                public void run() {
                    for(int i = 0;i<h;i++)
                    {
                        a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
                    }
                }
            });
            t1.start();
            t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr2, 0, h);
        System.arraycopy(a2, 0, arr2, h, h);
        System.currentTimeMillis();
        System.out.println("время расчета формулы в двух потоках: " + (System.currentTimeMillis() - a));
    }
}
