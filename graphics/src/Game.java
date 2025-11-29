import java.util.Vector;
import java.util.Scanner;

public class Game implements Screen {
    private static int maxDifficulty = 5;
    private static int incrementGuess = 3;
    private static int minGuess = 3;
    private static int maxAnswer = 121;
    private static int incrementAnswer = 15;

    private int difficulty;
    private int answer;
    private int maxGuesses;
    private Vector<Integer> guesses;
    private int status = 0;
    // 0 in progress, 1 succeed, -1 fail
    private int nGuesses = 0;
    private Scanner stdin;

    private static boolean checkDifficulty(int difficulty) {
        return (difficulty > 0 && difficulty <= maxDifficulty);
    }

    public Game(Scanner stdin) {
        int difficulty = 0;

        while (!Game.checkDifficulty(difficulty)) {
            System.out.println("Select your difficulty: [1-" + Game.maxDifficulty + "] (inclusive)");
            difficulty = stdin.nextInt();
        }
        this(stdin, difficulty);
    }

    private Game(Scanner stdin, int difficulty) {
        this.stdin = stdin;
        this.difficulty = difficulty;
        this.maxGuesses = (maxDifficulty-difficulty)*incrementGuess+minGuess;
        this.generateAnswer();
        this.guesses = new Vector<>();
    }

    private void generateAnswer() {
        this.answer = (int)(Math.random() * (double) (maxAnswer+this.difficulty*incrementAnswer));
    }

    public void display() {
        while (this.status == 0) {
            System.out.printf("%d guesses left.\nInput your new guess:\n", this.maxGuesses - this.nGuesses);
            int guess = this.stdin.nextInt();
            System.out.println("Your guess is: " + guess);
            this.newGuess(guess);
        }
    }

    private void gameOver() {
        assert (nGuesses == maxGuesses);
        this.status = -1;
        System.out.println("Game over");
    }

    private void newGuess(int guess) {
        this.nGuesses++;
        this.guesses.add(guess);
        if (guess == answer) {
            status = 1;
            System.out.println("correct");
        } else if (nGuesses == maxGuesses) {
            gameOver();
        } else if (guess < answer) {
            System.out.println("go higher");
        } else {
            System.out.println("go lower");
        }
    }

    public int getStatus() {
        return status;
    }

    public int getnGuesses() {
        return nGuesses;
    }

    public int getMaxGuesses() {
        return maxGuesses;
    }

    public int getdifficulty() {
        return difficulty;
    }
}
