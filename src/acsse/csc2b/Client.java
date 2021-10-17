/**
 * 
 */
package acsse.csc2b;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.UnknownHostException;

/**
 * @author Thalukanyo
 *
 */
public class Client {
	private Socket socket;
	private InetAddress ipAddress;
	
	public Client()
	{
		socket = null;
	}
	/**
	 *establishConnection method will try initiate connection in each port 
	 *and connect if connection is possible  
	 */
	public void establishConnection() 
	{
		try {
			ipAddress = InetAddress.getLocalHost();
		}catch(IOException ex) {
			System.out.println("Could not find IP Address.");
		}
		
		System.out.println("The computer IP Address is: " + ipAddress);
		for(int i =1;i<65535;i=i+4)
		{
			try {
				
				socket = new Socket("localhost",i);
				System.out.println("Program connected to localhost port: " + i);
				System.out.println("Local port of the connection: " + socket.getLocalPort());
				System.out.println("Remote port of the connection: " + socket.getPort()) ;
				
			}
			catch(UnknownHostException ex)
			{
				System.err.println("An unknown error has occurred!");
			}
			catch(IOException e) 
			{
				System.err.println("Could not connect to localhost port: " + i);
			}finally {
				//closing the port 
				try {
					if(socket != null)
						socket.close();
				}catch(IOException e) 
				{
					//When a port cannot close
					System.err.println("Could not close port: " + i);
				}
			}
			
		}
	
	}
}
