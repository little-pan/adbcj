package org.adbcj.h2.protocol;

/**
 * @author roman.stoffel@gamlor.info
 */
public enum CommandCodes {
    SESSION_PREPARE(0),
    COMMAND_EXECUTE_UPDATE(3),
    COMMAND_CLOSE(4),
    SESSION_PREPARE_READ_PARAMS(11),
    SESSION_SET_ID(12);

    private final int statusValue;

    private CommandCodes(int statusValue) {
        this.statusValue = statusValue;
    }

    public int getCommandValue() {
        return statusValue;
    }

    public boolean isCommand(int status) {
        return this.statusValue == status;
    }

    public static CommandCodes commandFor(int command) {
        for (CommandCodes cmd : values()) {
            if(cmd.getCommandValue()==command){
                return cmd;
            }
        }
        throw new IllegalStateException("Cannot interpret command: "+command);
    }
}
