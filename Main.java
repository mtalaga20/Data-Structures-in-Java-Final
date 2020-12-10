//Implementing a dance club waiting line, which will reach a max capacity and be forced to remove at the end of the line. Special guests will also be able to go to the front of the line.


class Main {
  public static void main(String[] args) {
    DanceClubLine<String> DanceLine = new DanceClubLine();
    
    //Adding at the end of the line
    DanceLine.addToLine("OJ");
    DanceLine.addToLine("Reece");
    DanceLine.addToLine("Alex");
    DanceLine.addToLine("Amy");
    DanceLine.addToLine("Sarah");
    DanceLine.addToLine("Michael");
    
    DanceLine.printList();
    System.out.println("");
    //Allowing 1 guest in
    DanceLine.letIn();
    System.out.println("");

    //Adding at the front of the line
    DanceLine.addToFront("Oprah");
    DanceLine.addToFront("Tom Brady");

    DanceLine.printList();
    System.out.println("");

    //Sending person at the back home
    DanceLine.sendAway(2);



    //Removing the first person in line specifically
    DanceLine.removeInLine(0);

    //Replace someone on line for someone else
    DanceLine.replaceInLine("Jeter", 0);

    //Inserting near the front
    DanceLine.insertInLine("Jimmy", 0);
    DanceLine.insertInLine("Tom Brady", 5);

    System.out.println("");
    DanceLine.printList();

    DanceLine.letInGroup(3); //Let's in 3 people
    
    System.out.println("");
    DanceLine.printList();

    System.out.println("");
    DanceLine.printCustomers();
    
  }
}