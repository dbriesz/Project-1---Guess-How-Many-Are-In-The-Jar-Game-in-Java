public class Game {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();
        Jar jar = new Jar();

        prompter.setJar(jar);

        prompter.play();

        jar.fillJar();

        prompter.isWinner();
    }
}