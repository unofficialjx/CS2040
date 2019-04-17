import java.util.*;


public class Elections {
    class Candidate implements Comparable<Candidate> {
        String name;
        int numVotes;

        public Candidate(String name, int numVotes) {
            this.name = name;
            this.numVotes = numVotes;
        }


        private String getName() {
            return this.name;
        }

        private int getNumVotes() {
            return this.numVotes;
        }


        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Candidate)) {
                return false;
            }

            Candidate c = (Candidate) o;
            return this.name.equals(c.name) && this.numVotes == c.numVotes;
        }

        @Override
        public int compareTo(Candidate o) {
            return Comparator.comparing(Candidate::getNumVotes)
                    .thenComparing(Candidate::getName)
                    .compare(o, this); // descending order, maxVotes is at root
        }


        @Override
        public String toString() {
            return name;
        }
    }

    TreeSet<Candidate> candidateTree = new TreeSet<>();
    HashMap<String, Integer> nameMapToVotes = new HashMap<>();
    private void run() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int numVotes = sc.nextInt();
            Candidate c = new Candidate(name, numVotes);
            candidateTree.add(c);
            nameMapToVotes.put(name, numVotes);
            sc.nextLine();
        }

        int Q = sc.nextInt();

        while (sc.hasNext()) {
            String UPDATE = sc.next();
            int k = sc.nextInt();
            String name = sc.next();
            update(k, name);
        }
    }

    private void update(int k, String name) {
        int votes = nameMapToVotes.get(name);
        Candidate c = new Candidate(name, votes);
        candidateTree.remove(c);
        votes += k;
        candidateTree.add( new Candidate(name, votes) ); // O (log N)
        nameMapToVotes.replace(name, votes); // O(1)


        Candidate topCandidate = candidateTree.first();
        if ( candidateTree.higher(topCandidate) != null &&
                candidateTree.higher(topCandidate).getNumVotes() == topCandidate.getNumVotes() ) {
            System.out.println("Tie at " + topCandidate.getNumVotes() + " votes!");
        } else {
            System.out.println(topCandidate.getName()
                    + " is winning with " + topCandidate.getNumVotes() + " votes!");
        }

    }

    public static void main(String[] args) {
        Elections newElection = new Elections();
        newElection.run();
    }
}
