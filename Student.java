
/**
 * Instances of Student represent (not surprisingly) college students.
 * Students can join their college Library to obtain a LibraryCard
 * which they can then use to borrow TextBooks for their studies. 
 * The Students read the TextBooks that they borrow and return them
 * to the Library when they are finished.
 * A Student is finished studying when their LibraryCard 
 * expires and they can't get hold of any more books.
 * 
 * @author (Vaios Karpathakis) 
 * @version (coursework 2
 * 
 */
public class Student 
{
    private String name;
    public Library library;
    private LibraryCard studentCard;     
    private TextBook currentBook;
    
    public Student(String studentName, Library lib)
    {
        name = studentName;
        library = lib;
        studentCard = library.issueCard();
        currentBook = null; 
    }
    /**
     * Returns true if the student does not have a textbook to read,
     * but can't borrow one because his LibraryCard has expired.
     * Otherwise, it returns false.
     * @return True of false, depending on whether the student has finished studies.
     */
    public boolean finishedStudies()
    {
        return ( currentBook == null && studentCard.expired());
           
    }
    /**
     * If the student doesn't have a textbook,they try to borrow one from the library
     * If the student does have a book and it is not finished, then they read one chapter of the book.
     * Otherwise, the student has a book that's finished and so closes it and returns it to the library.
     * 
     * 
     */
    public void study()
    {
        if(currentBook == null) { 
            currentBook = library.borrowBook(studentCard);}

        else if(currentBook != null && !currentBook.isFinished()) {
            currentBook.readNextChapter(); }
        else { currentBook.closeBook(); 
            library.returnBook(currentBook);
            currentBook = null;
        }
    }
    /**
     * Prints out messages about the student.
     * @param none
     */
    public void describe()
    {
        if (currentBook == null) {
            System.out.println(name + " does not have a book and "); 
            studentCard.describe(); }
        else {
            System.out.println(name + "has a book and ");
            currentBook.describe(); }
    }    

}

