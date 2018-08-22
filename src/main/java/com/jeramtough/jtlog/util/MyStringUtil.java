package com.jeramtough.jtlog.util;

/**
 * Created by 11718
 * on 2017  October 13 Friday 23:34.
 */
public class MyStringUtil
{
	public static String splitByNumberOfRow(String text, int limitNumber)
	{
		int b = text.length() / limitNumber + 1;
		StringBuilder message = new StringBuilder();
		int c = 0;
		for (int i = 0; i < b; i++)
		{
			if (i != b - 1)
			{
				message.append(text.substring(c, c + limitNumber)).append("\n");
				c = c + limitNumber;
			}
			else
			{
				message.append(text.substring(c, text.length()));
			}
		}
		return message.toString();
	}
	
	
	public static String ObjectsToString(Object... os)
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (Object o : os)
		{
			if (o == null)
			{
				stringBuilder.append("[null]");
			}
			else
			{
				stringBuilder.append(o.toString());
			}
		}
		
		return stringBuilder.toString();
	}
}
