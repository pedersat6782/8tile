public class Main {
    public static void main(String[] args) {
    	boolean verbose = false ;
    	if(args.length>0){
			verbose=args[0].equals("-v");
			System.out.println("VERBOSE");
    	}
        Board rootBoard = BoardUtils.createBoard("Please enter the STARTING board, Enter \'b\' for a blank space ex. \"b12345678\"");
        Board goalStateBoard = BoardUtils.createBoard("Please enter the GOAL board, Enter \'b\' for a blank space ex. \"b12345678\"");
        if (rootBoard.solvable()) {
			System.out.println("Solvable");
            DepthFirstSearching.depthFirst(rootBoard, goalStateBoard, true,verbose);
            DepthFirstSearching.depthFirst(rootBoard, goalStateBoard, false,verbose);
            BreadthFirstSearching.breadthFirst(rootBoard, goalStateBoard, true,verbose);
            BreadthFirstSearching.breadthFirst(rootBoard, goalStateBoard, false,verbose);
            AStarSearching.aStar(rootBoard, goalStateBoard,verbose);
        } else {
            System.out.println("Not Solvable");
        }
    }
}
