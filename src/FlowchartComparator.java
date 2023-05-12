public class FlowchartComparator {
    public RepositoryInterface repo = Repository.getR();


    // Two methods: 1 that increments when a user creates a something in the flowchart and 1 that creates the correct flowchart stuff

    // Temporary Hardcoded Hashmap
    public void createHashmaps() {
        repo.putActual("Begin", 1);
        repo.putActual("Call a method", 1);
        repo.putActual("Instruction", 1);
        repo.putActual("Condition", 1);
        repo.putActual("Input or Output", 1);
        repo.putActual("Variable Declaration", 1);
        repo.putActual("End", 1);
        repo.putActual("Lines", 1);

        repo.putUserAns("Begin", 0);
        repo.putUserAns("Call a method", 0);
        repo.putUserAns("Instruction", 0);
        repo.putUserAns("Condition", 0);
        repo.putUserAns("Input or Output", 0);
        repo.putUserAns("Variable Declaration", 0);
        repo.putUserAns("End", 0);
        repo.putUserAns("Lines", 0);
    }

    public boolean compareFlowchartAnswers() {
        for (String element: repo.getMainObjects()) {
            if (!repo.getActual().get(element).equals(repo.getUserAns().get(element))) {
                return false;
            }
        }

        return true;
    }

    public void createUserAnswer() {
        createHashmaps();
        for (Shape shapeName: repo.getShapes()) {
            System.out.println(shapeName.getClass().getName());
            repo.putUserAns(shapeName.getClass().getName(), 1 + repo.getUserAns().get(shapeName.getClass().getName()));
        }
        System.out.println(repo.getUserAns());
    }


}
