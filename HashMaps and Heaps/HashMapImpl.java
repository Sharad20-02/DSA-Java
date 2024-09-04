import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {

    public static class HashMap<K, V>{
        private class HMNode{
            K key;
            V value;

            HMNode(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int size;
        private LinkedList<HMNode>[] buckets;

        public HashMap(){
            initBuckets(4);
            size = 0;
        }

        private void initBuckets(int N){
            buckets = new LinkedList[N];
            for(int bi=0; bi<buckets.length; bi++){
                buckets[bi] = new LinkedList<>();
            }
        }

        public void put(K key, V value){
            int bi = hashFn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di != -1){
                HMNode node = buckets[bi].get(di);
                node.value = value;
            }else{
                HMNode node = new HMNode(key, value);
                buckets[bi].add(node);
                size++;
            }

            double lambda = ( size * 1.0 ) / buckets.length;
            if(lambda > 2.0){
                rehash();
            }
        }

        private void rehash(){
            LinkedList<HMNode>[] oba = buckets;

            initBuckets(oba.length * 2);
            size = 0;

            for(int i=0; i<oba.length; i++){
                for(HMNode node : oba[i]){
                    put(node.key, node.value);
                }
            }
        }

        private int hashFn(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int getIndexWithinBucket(K key, int bi){
            int di = 0;
            for(HMNode node : buckets[bi]){
                if(node.key.equals(key)){
                    return di;
                }
                di++;
            }
            return -1;
        }

        public boolean containsKey(K key){
            int bi = hashFn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di == -1){
                return false;
            }else{
                return true;
            }
        }

        public V get(K key){
            int bi = hashFn(key);
            int di = getIndexWithinBucket(key, bi);
            
            if(di == -1){
                return null;
            }else{
                return buckets[bi].get(di).value;
            }
        }

        public int size(){
            return size;
        }

        public V remove(K key){
            int bi = hashFn(key);
            int di = getIndexWithinBucket(key, bi);

            if(di == -1){
                return null;
            }else{
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int bi=0; bi<buckets.length; bi++){
                for(HMNode node : buckets[bi]){
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String[] args) {
        
    }
}
