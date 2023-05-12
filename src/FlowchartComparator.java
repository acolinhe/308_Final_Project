public class FlowchartComparator {
    public RepositoryInterface repo = Repository.getR();

    // Two methods: 1 that increments when a user creates a something in the flowchart and 1 that creates the correct flowchart stuff

    // Temporary Hardcoded Hashmap
    public void createHardAnswer() {
        repo.putActual("Begin", 1);
        repo.putActual("Call a method", 1);
        repo.putActual("Instruction", 1);
        repo.putActual("Condition", 1);
        repo.putActual("Input or Output", 1);
        repo.putActual("Variable Declaration", 1);
        repo.putActual("End", 1);
        repo.putActual("Lines", 1);
    }

    public boolean compareFlowchartAnswers() {
        for (String element: repo.getMainObjects()) {
            if (!repo.getActual().get(element).equals(repo.getUserAns().get(element))) {
                return false;
            }
        }

        return true;
    }

}
