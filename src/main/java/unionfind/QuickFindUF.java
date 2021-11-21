package unionfind;

public class QuickFindUF {
    int[] id;

    // p and q are connected iff they have the same id
    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];  //check whether p and q are in the same component (2 array accesses)
    }


    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        // change all entries with id[p] to id[q] (at most 2N + 2 array accesses)
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
