import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by sreedish.ps on 2/21/16.
 */
public class TUZTRN {

    static class Edge {
        int x1, y1, x2, y2;

        public Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            return dist(edge) == dist(this);
        }

        private double dist(Edge edge) {
            return Math.sqrt((edge.x2 - edge.x1) * (edge.x2 - edge.x1) + (edge.y2 - edge.y1) * (edge.y2 - edge.y1));
        }

    }

    static class Triangle {
        Edge a, b, c;

        public Triangle(Edge a, Edge b, Edge c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static boolean congruent(Triangle T1, Triangle T2) {
        if (T1.a.equals(T2.a)) {
            if (doubleCheck(T1.b, T1.c, T2.b, T2.c)) {
                return true;
            }
        }
        if (T1.a.equals(T2.b)) {
            if (doubleCheck(T1.b, T1.c, T2.a, T2.c)) {
                return true;
            }
        }
        if (T1.a.equals(T2.c)) {
            if (doubleCheck(T1.b, T1.c, T2.a, T2.b)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doubleCheck(Edge a, Edge b, Edge x, Edge y) {
        if (a.equals(x) && b.equals(y)) {
            return true;
        }
        if (a.equals(y) && b.equals(x)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String a[], b[], c[], d[];
            Triangle cut1, cut2;


            a = br.readLine().split(" ");
            b = br.readLine().split(" ");
            c = br.readLine().split(" ");

            Edge x = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(b[0]), Integer.parseInt(b[1]));
            Edge y = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(c[0]), Integer.parseInt(c[1]));
            Edge z = new Edge(Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(b[0]), Integer.parseInt(b[1]));

            cut1 = new Triangle(x, y, z);


            a = br.readLine().split(" ");
            b = br.readLine().split(" ");
            c = br.readLine().split(" ");

            x = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(b[0]), Integer.parseInt(b[1]));
            y = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(c[0]), Integer.parseInt(c[1]));
            z = new Edge(Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(b[0]), Integer.parseInt(b[1]));

            cut2 = new Triangle(x, y, z);


            a = br.readLine().split(" ");
            b = br.readLine().split(" ");
            c = br.readLine().split(" ");
            d = br.readLine().split(" ");

            Edge q1 = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(b[0]), Integer.parseInt(b[1]));
            Edge q2 = new Edge(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(c[0]), Integer.parseInt(c[1]));
            Edge q3 = new Edge(Integer.parseInt(c[0]), Integer.parseInt(c[1]), Integer.parseInt(d[0]), Integer.parseInt(d[1]));
            Edge q4 = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(d[0]), Integer.parseInt(d[1]));
            Edge diag1 = new Edge(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(c[0]), Integer.parseInt(c[1]));
            Edge diag2 = new Edge(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(d[0]), Integer.parseInt(d[1]));

            Triangle p1 = new Triangle(q1,q2,diag1);
            Triangle p2 = new Triangle(q3,q4,diag1);


            Triangle p3 = new Triangle(q1,q4,diag2);
            Triangle p4 = new Triangle(q3,q2,diag2);


            if(congruent(cut1,p1) && congruent(cut2,p2)){
                System.out.println("Yes");
                continue;
            }

            if(congruent(cut1,p2) && congruent(cut2,p1)){
                System.out.println("Yes");
                continue;
            }

            if(congruent(cut1,p3) && congruent(cut2,p4)){
                System.out.println("Yes");
                continue;
            }

            if(congruent(cut1,p4) && congruent(cut2,p3)){
                System.out.println("Yes");
                continue;
            }


            System.out.println("No");


        }
    }
}
