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

	private static String billion(long number) //from 1,000,000,000,000 to 999,999,999,999,999,999
	{
		if (number >= 1000000000000L)
		{
			if (number == 1000000000000L)
				return "UN BILLÓN ";
			if (number < 2000000000000L)
				return "UN BILLÓN " + million(number % 1000000000000L);
			return thousand(number / 1000000000000L) + "BILLONES " + million(number % 1000000000000L);
		}
		return million(number);
	}

	private static String million(long number) //from 1,000,000 to 999,999,999,999
	{
		if (number >= 1000000)
		{
			if (number == 1000000)
				return "UN MILLÓN ";
			if (number < 2000000)
				return "UN MILLÓN " + thousand(number % 1000000);
			return thousand(number / 1000000) + "MILLONES " + thousand(number % 1000000);
		}
		return thousand(number);
	}

	private static String thousand(long number) //from 1000 to 999,999
	{
		if (number >= 1000)
		{
			if (number == 1000)
				return "UN MIL ";
			if (number < 2000)
				return "UN MIL " + hundred(number % 1000, false);
			return hundred(number / 1000, true) + "MIL " + hundred(number % 1000, false);
		}
		return hundred(number, false);
	}

	private static String hundred(long number, boolean bool) //from 100 to 999
	{
		if (number >= 100)
			for (int i = 9; i > 0; i--)
			{
				if (number == 100)
					return "CIEN ";
				if (number >= 100 * i)
					return hundreds[i - 1] + dozen(number % 100, bool);
			}
		return dozen(number, bool);
	}

	private static String dozen(long number, boolean bool) //from 1 to 99
	{
		for (int i = 9; i > 2; i--)
		{
			if (number < 30)
				return units[(int) number];
			if (number == 10 * i)
				return dozens[i - 3];
			if (bool && number >= 10 * i && (int) number % 10 == 1)
				return dozens[i - 3] + "Y UN ";
			if (number >= 10 * i)
				return dozens[i - 3] + "Y " + units[(int) number % 10];
		}
		return "";
	}

	public static String convert(long number) throws NumberIsTooLargeException
	{
		if (number == 0)
			return "CERO";
		if (number > 999999999999999999L || number < -999999999999999999L)
			throw new NumberIsTooLargeException("Fuera de limite");
		return number < 0 ? "MENOS " + billion(number * -1) : billion(number);
	}

	public static class NumberIsTooLargeException extends Exception
	{
		public NumberIsTooLargeException(String message)
		{
			super(message);
		}
	}
}
