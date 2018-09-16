package com.jeramtough.jtlog.style;

import com.jeramtough.jtlog.log.LogInformation;

public class ArrivePrintStyle extends BasePrintStyle
{
	@Override
	public String stylize(LogInformation logInformation)
	{
		String message = getHead(logInformation) + getPosition(logInformation) +
				getCaller(logInformation);
		return message;
	}
}