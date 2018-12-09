package Game;

public class UserInput {

    public Command getCommand(char keyChar) {
        switch(keyChar) {
            case 'a':
                return Command.LEFT;
            case 'd':
                return Command.RIGHT;
            case ' ':
                return Command.SPACE;
            case 'q':
                return Command.QUIT;
            case 'i':
                return Command.INFO;
            default:
                return Command.NOTHING;
        }
    }
}
