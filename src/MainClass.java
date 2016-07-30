import java.util.Scanner;

/**
 * Created by alexs on 7/21/2016.
 */
public class MainClass extends NumbersToWordsES
{
	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args)
	{
		try
		{
			System.out.println(convert(getLong()));
		}
		catch (NumberIsTooLargeException | NumberFormatException e)
		{
			e.printStackTrace();
		}
	}

	private static String getString()
	{
		String line;
		while (true)
		{
			line = in.nextLine();
			if (line.isEmpty())
				continue;
			return line;
		}
	}

	private static long getLong()
	{
		String number = getString();
		StringBuilder n = new StringBuilder(1);
		if (number.charAt(0) == 45)
			n.append(number.charAt(0));
		for (int i = 0; i < number.length(); i++)
			if (number.charAt(i) > 47 && number.charAt(i) < 58)
				n.append(number.charAt(i));
		number = n.toString();
		return number.isEmpty() ? getLong() : Long.parseLong(number);
	}
}
