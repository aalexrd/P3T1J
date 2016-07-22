import java.util.Scanner;

/**
 * Created by alexs on 7/21/2016.
 */
public class MainClass
{
	private static final Scanner in = new Scanner(System.in);

	public static void main(String[] args)
	{
		NumbersToWords n = new NumbersToWords();
		System.out.println(n.convert(getDouble()));
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

	private static double getDouble()
	{
		String number = getString();
		StringBuilder n = new StringBuilder(1);
		for (int i = 0; i < number.length(); i++)
		{
			char c = number.charAt(i);
			if (c > 47 && c < 58)
				n.append(c);
		}
		number = n.toString();
		return number.isEmpty() ? getDouble() : Double.parseDouble(number);
	}
}
