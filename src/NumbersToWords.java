/**
 * Created by alexs on 7/21/2016.
 */
public class NumbersToWords
{

	private static final String[] units = {"", "UNO ", "DOS ", "TRES ", "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
			"ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISÉIS ", "DIECISIETE ", "DIECIOCHO ", "DIECINUEVE ", "VEINTE ", "VEINTIUNO ",
			"VEINTIDÓS ", "VEINTITRÉS ", "VEINTICUATRO ", "VEINTICINCO ", "VEINTISÉIS ", "VEINTISIETE ", "VEINTIOCHO ", "VEINTINUEVE "};
	private static final String[] dozens = {"TREINTA ", "CUARENTA ", "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA "};
	private static final String[] hundreds = {"CIENTO ", "DOSCIENTOS ", "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ", "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};


	private String billions(double number) //from 1,000,000,000,000 to 999,999,999,999,999,999
	{
		if (number >= 1000000000000L)
		{
			if (number == 1000000000000L)
				return "UN BILLÓN ";
			else if (number < 2000000000000L)
				return "UN BILLÓN " + millions(number % 1000000000000L);
			else
				return thousands( (number / 1000000000000L)) + "BILLONES " + millions(number % 1000000000000L);
		}
		return millions(number);
	}

	private String millions(double number) //from 1,000,000 to 999,999,999,999
	{
		if (number >= 1000000)
		{
			if (number == 1000000)
				return "UN MILLÓN ";
			else if (number < 2000000)
				return "UN MILLÓN " + thousands( number % 1000000);
			else
				return thousands( number / 1000000) + "MILLONES " + thousands( number % 1000000);
		}
		return thousands( number);
	}

	private String thousands(double number) //from 1000 to 999,999
	{
		if (number >= 1000)
			if (number == 1000)
				return "MIL ";
			else if (number < 2000)
				return "MIL " + hundreds(number % 1000);
			else
				return hundreds(number / 1000) + "MIL " + hundreds(number % 1000);
		return hundreds(number);
	}

	private String hundreds(double number) //from 100 to 999
	{
		if (number >= 100)
			for (int i = 9; i > 0; i--)
				if (number == 100)
					return "CIEN ";
				else if (number >= 100 * i)
					return hundreds[i - 1] + dozens(number % 100);
		return dozens(number);
	}

	private String dozens(double number) //from 1 to 99
	{
		for (int i = 9; i > 2; i--)
			if (number < 30)
				return units[(int)number];
			else if (number == 10 * i)
				return dozens[i - 3];
			else if (number >= 10 * i)
				return dozens[i - 3] + "Y " + units[(int)number % 10];
		return "";
	}

	public String convert(double number)
	{
		return billions(number);
	}
}
