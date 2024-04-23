import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;

public class Ventana extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    int x = 310, y = 205;
    int dir = 0;
    private JLabel lblCronometro;
    private int segundos = 0;
    private Timer timer;
    Player p1 = new Player(x,y,15,15,"#33FFCA");
    Player obstaculos [] = {
    		new Player(27, 32, 2, 313,"#21130d"),
    		new Player(591, 32, 2, 313,"#21130d"),
    		new Player(64, 33, 530, 2,"#21130d"),
    		new Player(27, 343, 530, 2,"#21130d"),
    		new Player(27, 315, 41, 2,"#21130d"),
    		new Player(27, 259, 41, 2,"#21130d"),
    		new Player(177, 317, 2, 28,"#21130d"),
    		new Player(102, 315, 41, 2,"#21130d"),
    		new Player(64, 286, 41, 2,"#21130d"),
    		new Player(102, 186, 2, 128,"#21130d"),
    		new Player(64, 153, 2, 75,"#21130d"),
    		new Player(64, 183, 41, 2,"#21130d"),
    		new Player(102, 259, 41, 2,"#21130d"),
    		new Player(141, 260, 2, 28,"#21130d"),
    		new Player(141, 286, 75, 2,"#21130d"),
    		new Player(214, 286, 2, 28,"#21130d"),
    		new Player(214, 315, 164, 2,"#21130d"),
    		new Player(27, 64, 75, 2,"#21130d"),
    		new Player(102, 65, 2, 86,"#21130d"),
    		new Player(64, 95, 41, 2,"#21130d"),
    		new Player(64, 125, 41, 2,"#21130d"),
    		new Player(141, 165, 2, 63,"#21130d"),
    		new Player(141, 226, 41, 2,"#21130d"),
    		new Player(177, 226, 2, 35,"#21130d"),
    		new Player(177, 259, 75, 2,"#21130d"),
    		new Player(250, 259, 2, 28,"#21130d"),
    		new Player(250, 286, 41, 2,"#21130d"),
    		new Player(289, 226, 2, 62,"#21130d"),
    		new Player(214, 226, 2, 35,"#21130d"),
    		new Player(177, 196, 75, 2,"#21130d"),
    		new Player(250, 165, 2, 63,"#21130d"),
    		new Player(141, 164, 108, 2,"#21130d"),
    		new Player(288, 226, 75, 2,"#21130d"),
    		new Player(325, 263, 2, 54,"#21130d"),
    		new Player(359, 286, 41, 2,"#21130d"),
    		new Player(325, 259, 75, 2,"#21130d"),
    		new Player(398, 153, 2, 192,"#21130d"),
    		new Player(399, 183, 41, 2,"#21130d"),
    		new Player(438, 153, 41, 2,"#21130d"),
    		new Player(361, 142, 2, 86,"#21130d"),
    		new Player(289, 125, 2, 75,"#21130d"),
    		new Player(289, 196, 41, 2,"#21130d"),
    		new Player(177, 64, 2, 102,"#21130d"),
    		new Player(175, 125, 116, 2,"#21130d"),
    		new Player(102, 125, 41, 2,"#21130d"),
    		new Player(141, 64, 2, 63,"#21130d"),
    		new Player(325, 107, 2, 91,"#21130d"),
    		new Player(325, 107, 232, 2,"#21130d"),
    		new Player(214, 32, 2, 65,"#21130d"),
    		new Player(214, 64, 66, 2,"#21130d"),
    		new Player(477, 153, 2, 102,"#21130d"),
    		new Player(438, 214, 41, 2,"#21130d"),
    		new Player(398, 253, 81, 2,"#21130d"),
    		new Player(438, 286, 119, 2,"#21130d"),
    		new Player(438, 315, 155, 2,"#21130d"),
    		new Player(516, 153, 2, 135,"#21130d"),
    		new Player(278, 64, 2, 30,"#21130d"),
    		new Player(239, 95, 41, 2,"#21130d"),
    		new Player(555, 107, 2, 109,"#21130d"),
    		new Player(516, 253, 46, 2,"#21130d"),
    		new Player(438, 286, 2, 28,"#21130d"),
    		new Player(457, 64, 2, 45,"#21130d"),
    		new Player(343, 64, 214, 2,"#21130d"),
    		new Player(30, 32, 33, 20,"#0fbf6c"),
    		new Player(557, 327, 33, 20,"#0fbf6c"),
    		};

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Ventana window = new Ventana();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Ventana() {
        initialize();
     iniciarCronometro();
     iniciarMovimientoJugador();
    }

    private void initialize() {
        frame = new JFrame("Laberinto");
        frame.setBounds(100, 100, 638, 470);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JPanel pnlLienzo = new JPanel(){
			@Override
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D pinta = (Graphics2D)g;	
				pinta.setColor(Color.decode(p1.getColor()));
				pinta.fillRect(p1.getX(),p1.getY(),p1.getW(),p1.getH());
				
				for (Player obstaculo : obstaculos) {
					pinta.setColor(Color.decode(obstaculo.getColor()));
					pinta.fillRect(obstaculo.getX(),obstaculo.getY(),obstaculo.getW(),obstaculo.getH());
				}
				
			}
		};
        pnlLienzo.setBackground(new Color(128, 128, 192));
		frame.getContentPane().add(pnlLienzo);
		pnlLienzo.setBounds(0, 0, 622, 369);
		pnlLienzo.setLayout(null);
		
		 

		JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 128, 128));
        panel.setBounds(0, 368, 622, 63);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        lblCronometro = new JLabel("00:00:00");
	    lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
	    lblCronometro.setFont(new Font("Tahoma", Font.PLAIN, 19));
	    lblCronometro.setBounds(100, 20, 105, 25);
	    panel.add(lblCronometro);
	        
        JButton btnReinicio = new JButton("Reiniciar");
        btnReinicio.setBackground(new Color(255, 255, 255));
        btnReinicio.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnReinicio.setBounds(248, 11, 132, 41);
        btnReinicio.setFocusable(false);
        panel.add(btnReinicio);
        
        btnReinicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				p1.setX(310);
				p1.setY(205);
				frame.repaint();
				segundos = 0;
		        actualizarTiempo();
		        timer.start();
			}
		});
        

       frame.addKeyListener(this);
       
       
    }

    private void iniciarCronometro() {
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                segundos++;
                int horas = segundos / 3600;
                int minutos = (segundos % 3600) / 60;
                int segundosRestantes = segundos % 60;
                String tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
                lblCronometro.setText(tiempoFormateado);
            }
        };
        timer = new Timer(1000, taskPerformer);
        timer.start();
    }
    
    private void actualizarTiempo() {
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundosRestantes = segundos % 60;
        String tiempoFormateado = String.format("%02d:%02d:%02d", horas, minutos, segundosRestantes);
        lblCronometro.setText(tiempoFormateado);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
      
        switch(e.getKeyCode()) {
        case 87:
        	dir = 1;
        	break;

        case 83:
        	dir = 2;
        	break;

        case 68:
        	dir = 3;
        	break;

        case 65:
        	dir = 4;
        	break;

        default:
       		break;
        }
        
        frame.repaint();
        update();
    }

    public void update(){
    	 int newX = p1.getX();
    	 int newY = p1.getY();

    	    switch (dir) {
    	        case 1: 
    	            newY -= 10;
    	            break;
    	        case 2:
    	            newY += 10;
    	            break;
    	        case 3: 
    	            newX += 10;
    	            break;
    	        case 4: 
    	            newX -= 10;
    	            break;
    	    }

    	    boolean canMove = true;
    	    boolean win = false;

    	    for (Player obstaculo : obstaculos) {
    	        if (p1.colision(obstaculo).equals("Colision")) {
    	        	if (obstaculo.getX() == 30 && obstaculo.getY() == 32) {
    	                win = true;
    	            } else if (obstaculo.getX() == 557 && obstaculo.getY() == 327) { 
    	                win = true;
    	            } else {
    	                canMove = false;
    	                break;
    	            }
    	            break;
    	        }
    	    }
    	    
    	    if (win == true) {
    	    	timer.stop();
    	        JOptionPane.showMessageDialog(null, "¡Ganaste en " + segundos + " segundos!");
    	        p1.setX(310);
				p1.setY(205);
				segundos = 0;
		        actualizarTiempo();
				frame.repaint();
    	        return;
    	    }
    	    
    	    if (!canMove) {
    	        switch (dir) {
    	            case 1:
    	                newY += 20;
    	                break;
    	            case 2:
    	                newY -= 20;
    	                break;
    	            case 3:
    	                newX -= 20;
    	                break;
    	            case 4:
    	                newX += 20;
    	                break;
    	        }
    	    }
    	    
    	    p1.setX(newX);
    	    p1.setY(newY);

    	    frame.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {
     
    }
    
    private void iniciarMovimientoJugador() {
        ActionListener moverJugador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        };
        timer = new Timer(200, moverJugador);
        timer.start();
    }

}