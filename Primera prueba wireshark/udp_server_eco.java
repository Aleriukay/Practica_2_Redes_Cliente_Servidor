import java.io.IOException;
import java.net.*;

public class udp_server_eco {
	private static final int ECHOMAX = 255; // Tamagno maximo de los mensajes

	public static void main(String[] args) throws IOException
	{
		DatagramSocket socket = new DatagramSocket(6789);
		DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
		
		while (true)
		{
			socket.receive(packet); // Recibe un datagrama del cliente
			System.out.println(
					"IP cliente: " + packet.getAddress().getHostAddress() + " Puerto cliente: " + packet.getPort());
			socket.send(packet); // Enviar el mismo datagrama al cliente
			packet.setLength(ECHOMAX); // Limpiar buffer
		}
	}
}