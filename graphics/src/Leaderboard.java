import java.util.Vector;

public class Leaderboard implements Screen {
    public Vector<Game> games;

    Leaderboard() {
        this.games = new Vector<>();
    }

    public void display() {
        System.out.println("Leaderboard:");
        System.out.println("Game\t| Status\t| Guesses Used");

        int totalWins = 0;
        int totalGames = games.size();
        int totalDifficulty = 0;
        double percentGuessUsed = 0.0;

        for (int i = 0; i < totalGames; i++) {
            Game game = games.get(i);
            int status = game.getStatus();
            int nGuesses = game.getnGuesses();
            int maxGuesses = game.getMaxGuesses();
            if (status==1) {
                totalWins++;
                percentGuessUsed += ((double) nGuesses)/((double) totalWins);
                totalDifficulty += game.getdifficulty();
            }
            System.out.println(switch (status) {
                case 0 -> i + "\t\t| In progress\t| " + nGuesses + "/" + maxGuesses;
                case 1 -> i + "\t\t| Success\t| " + nGuesses + "/" + maxGuesses;
                case -1 -> i + "\t\t| Failed\t| " + nGuesses + "/" + maxGuesses;
                default -> i + "\t\t| Unknown\t| " + nGuesses + "/" + maxGuesses;
            });
        }

        System.out.println("\n\nStatistics:");
        double winRate = ((double) totalWins)/((double) totalGames) * 100;
        System.out.printf("Win rate: %.1f\%\n", winRate);
        double percentGuessRate = ((double) percentGuessUsed)/((double) totalWins);
        System.out.printf("Percent guess used for winning games: %.2f\n", percentGuessRate);
        double difficultyAvg = ((double) totalDifficulty)/((double) totalWins);
        System.out.printf("Average difficulty for winning games: %.1f\n", difficultyAvg);
    }

    public void addGame(Game game) {
        this.games.add(game);
    }
}
