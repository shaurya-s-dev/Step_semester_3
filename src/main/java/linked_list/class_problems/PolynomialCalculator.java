package linked_list.class_problems;

/**
 * Problem 9: Polynomial Calculator
 */
public class PolynomialCalculator {

    public static class Node {
        public int coeff;
        public int exp;
        public Node next;

        public Node(int coeff, int exp) {
            this.coeff = coeff;
            this.exp = exp;
            this.next = null;
        }

        public Node(int coeff, int exp, Node next) {
            this.coeff = coeff;
            this.exp = exp;
            this.next = next;
        }
    }

    public static Node addPolynomials(Node p, Node q) {
        Node dummy = new Node(0, 0);
        Node tail = dummy;

        while (p != null && q != null) {
            if (p.exp > q.exp) {
                if (p.coeff != 0) {
                    tail.next = new Node(p.coeff, p.exp);
                    tail = tail.next;
                }
                p = p.next;
            } else if (q.exp > p.exp) {
                if (q.coeff != 0) {
                    tail.next = new Node(q.coeff, q.exp);
                    tail = tail.next;
                }
                q = q.next;
            } else {
                int sumCoeff = p.coeff + q.coeff;
                if (sumCoeff != 0) {
                    tail.next = new Node(sumCoeff, p.exp);
                    tail = tail.next;
                }
                p = p.next;
                q = q.next;
            }
        }

        while (p != null) {
            if (p.coeff != 0) {
                tail.next = new Node(p.coeff, p.exp);
                tail = tail.next;
            }
            p = p.next;
        }

        while (q != null) {
            if (q.coeff != 0) {
                tail.next = new Node(q.coeff, q.exp);
                tail = tail.next;
            }
            q = q.next;
        }

        return dummy.next;
    }

    public static String toStandardForm(Node head) {
        if (head == null) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        Node curr = head;
        boolean isFirst = true;

        while (curr != null) {
            int c = curr.coeff;
            int e = curr.exp;

            if (c != 0) {
                if (isFirst) {
                    if (c < 0) {
                        sb.append("-");
                    }
                    formatTerm(sb, Math.abs(c), e);
                    isFirst = false;
                } else {
                    if (c > 0) {
                        sb.append(" + ");
                    } else {
                        sb.append(" - ");
                    }
                    formatTerm(sb, Math.abs(c), e);
                }
            }
            curr = curr.next;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    private static void formatTerm(StringBuilder sb, int absCoeff, int exp) {
        if (exp == 0) {
            sb.append(absCoeff);
        } else if (exp == 1) {
            if (absCoeff != 1) {
                sb.append(absCoeff);
            }
            sb.append("x");
        } else {
            if (absCoeff != 1) {
                sb.append(absCoeff);
            }
            sb.append("x^").append(exp);
        }
    }
}
