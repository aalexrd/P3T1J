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
		while (true)
		{
			String line = in.nextLine();
			if (line.isEmpty())
				continue;
			return line;
		}
	}

	private static long getLong()
	{
		String number = getString();
		StringBuilder n = new StringBuilder(1);
		for (int i = 0; i < number.length(); i++)
		{
			char c = number.charAt(i);
			if (c > 47 && c < 58 || c == 45)
				n.append(c);
		}
		number = n.toString();
		return number.isEmpty() ? getLong() : Long.parseLong(number);
	}
}
