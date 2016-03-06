public class Quiz {
        private int alpha=0;
        private static int beta=0;

        public void increment() {
          alpha++;
          beta++;
        }

        public void display() {
          System.out.println(alpha+" "+beta);
        }

        public static void main(String[] args){
          Quiz x = new Quiz();
          Quiz y = new Quiz();

          x.increment();        //alpha_x = 1, beta = 1
          y.increment();        //alpha_y = 1, beta = 2
          x.increment();        //alpha_x = 2, beta = 3

          x.display();        // 2 3
          y.display();        // 1 3

          x = y;              // alpha_x = 1, beta = 3
          x.increment();      // alpha_x = 2, beta = 4
             
          x.display();        // 2 4
          y.display();        // 1 4

          x.increment();
          x.display();
          y.display();
        }
     }