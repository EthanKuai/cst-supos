import java.util.Scanner;

public class GameManager implements Screen {
    private Leaderboard lb;
    private Scanner stdin;

    public GameManager() {
        this.stdin = new Scanner(System.in);
        this.lb = new Leaderboard();
    }

    public void display() {
        System.out.println("Welcome to a lame game!");
        char inn;
        while (true) {
            System.out.println("'g' for new game, 'l' for leaderboards, 'e' to exit [g/l/e]");
            inn = stdin.next().charAt(0);
            if (inn == 'g') newGame();
            else if (inn == 'l') this.lb.display();
            else if (inn == 'e') return;
        }
    }

    private void newGame() {
        System.out.println("Starting new game...");
        Game game = new Game(this.stdin);
        this.lb.addGame(game);
        game.display();
        System.out.println("Game Ended~");
    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.display();
    }
}
