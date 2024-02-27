import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;



public class KruskalMST
{
    private Queue<Edge> mst = new Queue<Edge>();

    public KruskalMST(Graph G) {
        MinPQ<Edge> pq = new MinPQ<>(G.edges(), Comparator.comparingDouble(Edge::getDistance));

        
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.deleteMin();
            City vn = e.either(), wn = e.other(vn);
            int v = G.getIndex(vn.getName());
            int w = G.getIndex(wn.getName());
    
            if (!uf.isConnected(v, w)) {
                uf.union(v, w);
                mst.enqueue(e);
            }
        }
    }
    

   public Iterable<Edge> edges()
   {  return mst;  }

   
}


 class Queue<T> implements Iterable<T>{
    private LinkedList<T> elements = new LinkedList<>();

    public void enqueue(T element) {
        elements.addLast(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
     public Iterator<T> iterator() {
        return elements.iterator();
    }
   }

   