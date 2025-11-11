package Exception;

class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String msg) { super(msg); }
}
class TimeOutException extends Exception {
    public TimeOutException(String msg) { super(msg); }
}
class QuestionNotFoundException extends Exception {
    public QuestionNotFoundException(String msg) { super(msg); }
}

class Exam {
    String username = "Selim";
    String password = "pass";
    String[] questions = {"Q1: 2+2?", "Q2: Capital of Bangladesh?"};
    boolean loggedIn = false;

    public void login(String user, String pass) throws InvalidCredentialsException {
        if (!user.equals(username) || !pass.equals(password))
            throw new InvalidCredentialsException("Invalid username or password!");
        loggedIn = true;
        System.out.println("Login successful.");
    }

    public void startExam(int timeRemaining) throws TimeOutException {
        if (timeRemaining <= 0)
            throw new TimeOutException("Time limit exceeded!");
        System.out.println("Exam started. Time left: " + timeRemaining + " mins.");
    }

    public void getQuestion(int index) throws QuestionNotFoundException {
        if (index < 0 || index >= questions.length)
            throw new QuestionNotFoundException("Invalid question index!");
        System.out.println(questions[index]);
    }
}

public class OnlineExam {
    public static void main(String[] args) {
        Exam exam = new Exam();
        try {
            exam.login("Selim", "pass");
            exam.startExam(30);
            exam.getQuestion(1);
            exam.getQuestion(5); // invalid index
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
