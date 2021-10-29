package hu.atig.tello.sdk.core.model.command;

public class ComplexCommand<ParameterType> extends AbstractCommand {
	
	public String parameterString;
	
	public ComplexCommand(String command, ParameterType ... parameterList) {
		super(command);
		
		StringBuilder parameterStringBuilder = new StringBuilder();
		for (ParameterType parameter: parameterList) {
			parameterStringBuilder.append(" ");
			parameterStringBuilder.append(parameter);
		}
		parameterString = parameterStringBuilder.toString();
	}

	@Override
	public String composeCommand() {
		StringBuilder commandBuilder = new StringBuilder(command);
		commandBuilder.append(parameterString);
		return commandBuilder.toString();
	}
}
