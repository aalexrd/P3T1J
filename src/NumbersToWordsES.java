/**
 * Created by alexs on 7/21/2016.
 */
public class NumbersToWordsES
{

	private static final String[] units = {"", "UNO ", "DOS ", "TRES ", "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
			"ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISÉIS ", "DIECISIETE ", "DIECIOCHO ", "DIECINUEVE ", "VEINTE ", "VEINTIUNO ",
			"VEINTIDÓS ", "VEINTITRÉS ", "VEINTICUATRO ", "VEINTICINCO ", "VEINTISÉIS ", "VEINTISIETE ", "VEINTIOCHO ", "VEINTINUEVE "};
	private static final String[] dozens = {"TREINTA ", "CUARENTA ", "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA "};
	private static final String[] hundreds = {"CIENTO ", "DOSCIENTOS ", "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ", "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};

	private static String billions(long number) //from 1,000,000,000,000 to 999,999,999,999,999,999
	{
		if (number >= 1000000000000L)
		{
			if (number == 1000000000000L)
				return "UN BILLÓN ";
			else if (number < 2000000000000L)
				return "UN BILLÓN " + millions(number % 1000000000000L);
			else
				return thousands(number / 1000000000000L) + "BILLONES " + millions(number % 1000000000000L);
		}
		return millions(number);
	}

	private static String millions(long number) //from 1,000,000 to 999,999,999,999
	{
		if (number >= 1000000)
		{
			if (number == 1000000)
				return "UN MILLÓN ";
			else if (number < 2000000)
				return "UN MILLÓN " + thousands(number % 1000000);
			else
				return thousands(number / 1000000) + "MILLONES " + thousands(number % 1000000);
		}
		return thousands(number);
	}

	private static String thousands(long number) //from 1000 to 999,999
	{
		if (number >= 1000)
			if (number == 1000)
				return "UN MIL ";
			else if (number < 2000)
				return "UN MIL " + hundreds(number % 1000, false);
			else
				return hundreds(number / 1000, true) + "MIL " + hundreds(number % 1000, false);
		return hundreds(number, false);
	}

	private static String hundreds(long number, boolean bool) //from 100 to 999
	{
		if (number >= 100)
			for (int i = 9; i > 0; i--)
				if (number == 100)
					return "CIEN ";
				else if (number >= 100 * i)
					return hundreds[i - 1] + dozens(number % 100, bool);
		return dozens(number, bool);
	}

	private static String dozens(long number, boolean bool) //from 1 to 99
	{
		for (int i = 9; i > 2; i--)
			if (number < 30)
				return units[(int) number];
			else if (number == 10 * i)
				return dozens[i - 3];
			else if (bool && number >= 10 * i && (int) number % 10 == 1)
				return dozens[i - 3] + "Y UN ";
			else if (number >= 10 * i)
				return dozens[i - 3] + "Y " + units[(int) number % 10];
		return "";
	}

	public static String convert(long number) throws NumberIsTooLargeException
	{
		if (number == 0)
			return "CERO";
		if (number > 999999999999999999L || number < -999999999999999999L)
			throw new NumberIsTooLargeException("El número es muy grande");
		return number < 0 ? "MENOS " + billions(number * -1) : billions(number);
	}

	public static class NumberIsTooLargeException extends Exception
	{
		public NumberIsTooLargeException(String message)
		{
			super(message);
		}
	}
}
