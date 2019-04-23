// The "LeagueLaunch" class.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class LeagueLaunch extends JFrame implements ActionListener
{

    //Content
    JLabel Title;
    JButton Btn_Launch;
    JButton Btn_Finish;

    //Container
    Container Launch;

    //Sysem Username
    public static String UName = System.getProperty ("user.name");


    public LeagueLaunch ()
    {
	super ("League of Legends Launch"); // Name

	//Content
	Title = new JLabel ("Optimize and Launch League of Legends");
	Btn_Launch = new JButton ("Launch");
	Btn_Finish = new JButton ("Finish");

	//Container Setup
	Launch = getContentPane ();
	Launch.setLayout (new GridLayout (3, 1));

	//Button Listener
	Btn_Launch.addActionListener (this);
	Btn_Finish.addActionListener (this);

	//Display Content
	Launch.add (Title);
	Launch.add (Btn_Launch);
	Launch.add (Btn_Finish);

	//GUI settings
	setSize (350, 150);     // Size
	show ();                // Frame
    } // Constructor


    //Action
    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == Btn_Launch)
	{
	    String YesorNo;

	    JOptionPane.showMessageDialog (null, "Yo " + UName + " ,please make sure that all of your work is saved because this software will close all applications that are not required by windows or League.");
	    YesorNo = JOptionPane.showInputDialog ("Please Type in your Computer Account Name in CAPS to continue");

	    if (YesorNo.equals (UName.toUpperCase ()))
	    {
		Launch_Game ();
	    }
	    else if (YesorNo.equals (UName.toLowerCase ()))
	    {
		JOptionPane.showMessageDialog (null, "Read the instructions TYPE YOUR NAME IN CAPS");
	    }
	    else
	    {
		JOptionPane.showMessageDialog (null, ">Incorrect Input<");
	    }
	}

	else if (e.getSource () == Btn_Finish)
	{
	    String Reboot;

	    JOptionPane.showMessageDialog (null, "I recommend that you restart your Computer/Laptop.");
	    Reboot = JOptionPane.showInputDialog ("Please Type in Reboot to restart your computer, else just leave it blank");

	    if (Reboot.equals ("REBOOT"))
	    {
		try
		{
		    Runtime.getRuntime ().exec ("C:\\Windows\\System32\\shutdown -r");
		}
		catch (IOException ioe)
		{
		    System.out.println ("error===" + ioe.getMessage ());
		    ioe.printStackTrace ();
		}
	    }
	    else
	    {
		Finish_Play ();
	    }
	}

    }


    public void Launch_Game ()
    {
	new NewWindow ();
	//Quit Desktop and Default Applications
	try
	{
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM explorer.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM OneDrive.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM Chrome.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM MicrosoftEdge.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM YourPhone.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM SkypeApp.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM OfficeClickToRun.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM WINWORD.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM POWERPNT.exe");
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM EXCEL.exe");
	}
	catch (IOException ioe)
	{
	    System.out.println ("error===" + ioe.getMessage ());
	    ioe.printStackTrace ();
	}

	//Launch League
	try
	{
	    Runtime.getRuntime ().exec ("C:\\Riot Games\\League of Legends\\LeagueClient.exe");
	}
	catch (IOException ioe)
	{
	    System.out.println ("error===" + ioe.getMessage ());
	    ioe.printStackTrace ();
	}
    }


    //Quit game and Launch Desktop and services
    public void Finish_Play ()
    {
	//Launch Desktop
	try
	{
	    Runtime.getRuntime ().exec ("C:\\WINDOWS\\explorer.exe");
	    //System.exit (0);
	}
	catch (IOException ioe)
	{
	    System.out.println ("error===" + ioe.getMessage ());
	    ioe.printStackTrace ();
	}

	//Quit League
	try
	{
	    Runtime.getRuntime ().exec ("TASKKILL /F /IM LeagueClient.exe");
	    //System.exit (0);
	}
	catch (IOException ioe)
	{
	    System.out.println ("error===" + ioe.getMessage ());
	    ioe.printStackTrace ();
	}
    }


    public static void main (String[] args) throws IOException
    {
	new LeagueLaunch ();
    }


    // Create a LeagueLaunch frame
} // LeagueLaunch class


public class NewWindow extends JFrame implements ActionListener
{
    //Content
    JLabel Title;
    JButton Btn_Launch_Browser;
    JButton Btn_Launch_Desktop;

    //Container
    Container Launch;

    //Sysem Username
    public static String UName = System.getProperty ("user.name");


    public NewWindow ()
    {
	super ("League of Legends Launch"); // Name

	//Content
	Title = new JLabel ("Apps you might need");
	Btn_Launch_Browser = new JButton ("Browser");
	Btn_Launch_Desktop = new JButton ("Desktop");

	//Container Setup
	Launch = getContentPane ();
	Launch.setLayout (new GridLayout (3, 1));

	//Button Listener
	Btn_Launch_Browser.addActionListener (this);
	Btn_Launch_Desktop.addActionListener (this);

	//Display Content
	Launch.add (Title);
	Launch.add (Btn_Launch_Browser);
	Launch.add (Btn_Launch_Desktop);

	//GUI settings
	setSize (350, 150);     // Size
	show ();                // Frame
    } // Constructor


    //Action
    public void actionPerformed (ActionEvent e)
    {
	if (e.getSource () == Btn_Launch_Browser)
	{
	    OpenBrowser ();
	}
	else if (e.getSource () == Btn_Launch_Desktop)
	{
	    RunDesktop ();
	}
    }


    public void OpenBrowser ()
    {
	try
	{
	    Runtime rt = Runtime.getRuntime ();
	    String url = "http://www.google.ca";
	    rt.exec ("rundll32 url.dll,FileProtocolHandler " + url);
	    //System.exit (0);
	}
	catch (IOException ioe)
	{
	    System.out.println ("error===" + ioe.getMessage ());
	    ioe.printStackTrace ();
	}
    }


    public void RunDesktop ()
    {
	//Launch Desktop
	try
	{
	    Runtime.getRuntime ().exec ("C:\\WINDOWS\\explorer.exe");
	    //System.exit (0);
	}
	catch (IOException ioe)
	{
	    System.out.println ("error===" + ioe.getMessage ());
	    ioe.printStackTrace ();
	}
    }


    public static void main (String[] args) throws IOException
    {
	new NewWindow ();
    }
}

