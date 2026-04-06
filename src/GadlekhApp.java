import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;



public class GadlekhApp extends JFrame {
    GadlekhApp(){
        seedData();
        seedQuiz();
        setTitle("GADLEKH: Graphical Archive for Data, Legacy, Exploration and Kingdom Heritage");
        setSize(1400,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Fort fort:fortlist)
        {
            listModel.addElement(fort.getName());
        }

        JList <String> fortJList = new JList<>(listModel);
        fortJList.setBackground(new java.awt.Color(0,0,0));
        fortJList.setForeground(new java.awt.Color(204,102,0));
        fortJList.setSelectionBackground(new java.awt.Color(204,102,0));
        fortJList.setSelectionForeground(new java.awt.Color(255,255,255));
        fortJList.setFont(new java.awt.Font("Sanserif",java.awt.Font.BOLD,15));

        imageLabel = new JLabel("GADLEKH : Graphical Archive for Data, Legacy, Exploration, and Kingdom Heritage", JLabel.CENTER);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new java.awt.Dimension(700,400));
        imageLabel.setBorder(new EmptyBorder(50,0,10,0));
        imageLabel.setHorizontalTextPosition(JLabel.CENTER); 
        imageLabel.setVerticalTextPosition(JLabel.TOP); 
        imageLabel.setFont(new java.awt.Font("Serif",java.awt.Font.BOLD,28));

        descriptionArea = new JTextArea();
        descriptionArea.setBackground(new java.awt.Color(0,0,0));
        descriptionArea.setEditable(false);
        descriptionArea.setFont(new java.awt.Font("Serif",java.awt.Font.PLAIN,18));
        descriptionArea.setForeground(new java.awt.Color(204,102,0));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setMargin(new java.awt.Insets(20, 20, 20, 20));
        descriptionArea.setText("Chhatrapati Shivaji Maharaj viewed forts as the \"very soul of the kingdom,\" a philosophy that guided his strategic expansion across the Deccan and Konkan regions. To him, a fort was not just a defensive structure but a source of sovereignty and protection for the local populace. His relationship with these landmarks began at Shivneri, his birthplace, and matured at Rajgad, which served as his administrative capital for over two decades. His visionary approach to naval supremacy led to the construction of sea fortresses like Sindhudurg and Vijaydurg, built to challenge foreign maritime powers and secure the coast.\r\n" + //
                                "\r\n" + //
                                "Beyond construction, his tactical brilliance was immortalized through daring feats, such as his escape from the siege at Panhala and the decisive victory at Pratapgad. He also expanded the Maratha influence deep into the south, capturing the \"impregnable\" Gingee in present-day Tamil Nadu to create a southern stronghold. Whether it was storing treasury at Lohagad or fortifying the highest peaks like Salher, Shivaji Maharaj meticulously transformed the Sahyadri topography into a sophisticated defensive network. Each fort reflects his commitment to Swarajya, serving as a testament to his engineering foresight and his indomitable spirit in establishing a self-ruled state.\n\n Select a fort to Start Exploring");
        
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new java.awt.Color(204,102,0));
        centerPanel.add(imageLabel,BorderLayout.NORTH);
        centerPanel.add(new JScrollPane(descriptionArea),BorderLayout.CENTER);

        JScrollPane listJScrollPane = new JScrollPane(fortJList);
        listJScrollPane.setPreferredSize(new java.awt.Dimension(200,0));
        listJScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("⚔ Forts"));

        JButton homeButton = new JButton("🏠 Return Home");
        homeButton.setFocusable(false);
        homeButton.setFont(new java.awt.Font("Sanserif", java.awt.Font.BOLD,14));
        homeButton.setBackground(new java.awt.Color(0,0,0));
        homeButton.setForeground(new java.awt.Color(255,255,255));

        JButton quizButton = new JButton("Test Your Knowledge !");
        quizButton.setFocusable(false);
        quizButton.setFont(new java.awt.Font("Sanserif", java.awt.Font.BOLD,16));
        quizButton.setBackground(new java.awt.Color(0,0,0));
        quizButton.setForeground(new java.awt.Color(255,255,255));


        JPanel sidebarPanel = new JPanel(new BorderLayout());
        sidebarPanel.add(listJScrollPane,BorderLayout.CENTER);
        sidebarPanel.add(homeButton, BorderLayout.NORTH);
        sidebarPanel.add(quizButton,BorderLayout.SOUTH);

        add(centerPanel,BorderLayout.CENTER);
        add(sidebarPanel,BorderLayout.WEST);

        //descriptionArea = new JTextArea();
        ImageIcon hero = new ImageIcon("assets/hero.jpg");
        Image scaledImage = hero.getImage().getScaledInstance(700,400, Image.SCALE_SMOOTH);
        ImageIcon scaledhero = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledhero);

        fortJList.addListSelectionListener(e ->{
            if (!e.getValueIsAdjusting()){
                int index = fortJList.getSelectedIndex();
                if (index != -1){
                    Fort selectedFort = fortlist.get(index);
                    descriptionArea.setText(selectedFort.getDescription());
                    ImageIcon icon = new ImageIcon(selectedFort.getFile_path());
                    imageLabel.setIcon(icon);
                    Image fortscaledImage = icon.getImage().getScaledInstance(600,400, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(fortscaledImage);
                    imageLabel.setText(selectedFort.getName());
                    imageLabel.setIcon(scaledIcon);
                    descriptionArea.setCaretPosition(0);
                    
                }
            }
        });
        
        homeButton.addActionListener(e ->{
            fortJList.clearSelection();
            imageLabel.setText("GADLEKH : Graphical Archive for Data, Legacy, Exploration, and Kingdom Heritage");
            imageLabel.setHorizontalTextPosition(JLabel.CENTER); 
            imageLabel.setVerticalTextPosition(JLabel.TOP);
            imageLabel.setBorder(new EmptyBorder(50,0,10,0));       
            descriptionArea.setText("Chhatrapati Shivaji Maharaj viewed forts as the \"very soul of the kingdom,\" a philosophy that guided his strategic expansion across the Deccan and Konkan regions. To him, a fort was not just a defensive structure but a source of sovereignty and protection for the local populace. His relationship with these landmarks began at Shivneri, his birthplace, and matured at Rajgad, which served as his administrative capital for over two decades. His visionary approach to naval supremacy led to the construction of sea fortresses like Sindhudurg and Vijaydurg, built to challenge foreign maritime powers and secure the coast.\r\n" + //
                                "\r\n" + //
                                "Beyond construction, his tactical brilliance was immortalized through daring feats, such as his escape from the siege at Panhala and the decisive victory at Pratapgad. He also expanded the Maratha influence deep into the south, capturing the \"impregnable\" Gingee in present-day Tamil Nadu to create a southern stronghold. Whether it was storing treasury at Lohagad or fortifying the highest peaks like Salher, Shivaji Maharaj meticulously transformed the Sahyadri topography into a sophisticated defensive network. Each fort reflects his commitment to Swarajya, serving as a testament to his engineering foresight and his indomitable spirit in establishing a self-ruled state.\n\nSelect a fort to Start Exploring");
            System.out.println("returned to home screen\n\nSelect a fort to Start Exploring");
            ImageIcon hero1 = new ImageIcon("assets/hero.jpg");
            Image scaledImage1 = hero1.getImage().getScaledInstance(700,400, Image.SCALE_SMOOTH);
            ImageIcon scaledhero1 = new ImageIcon(scaledImage1);
            imageLabel.setIcon(scaledhero1);

        });

        quizButton.addActionListener(e ->{
            fortJList.clearSelection();
            imageLabel.setText("Quiz");
            descriptionArea.setText("ATTEND THE QUIZ");
            int score = 0;
            for (Question q : quizList){
                String selection =(String) javax.swing.JOptionPane.showInputDialog(
                    this,
                    q.question,
                    "GADLEKH Quiz",
                    javax.swing.JOptionPane.QUESTION_MESSAGE,
                    null,
                    q.options,
                    q.options[0]
                );
            if (selection != null && selection.equals(q.options[q.correctIndex])){
                score++;
                javax.swing.JOptionPane.showMessageDialog(this,"Correct! ✅");
            }
            else if (selection != null){
                javax.swing.JOptionPane.showMessageDialog(this,"Wrong! ❌ The correct answer was: " + q.options[q.correctIndex]);
            }
            else{
                break;
            }
            javax.swing.JOptionPane.showMessageDialog(this,"Quiz Finished! Your Score: " + score + "/" + quizList.size());


            }
        });
        
    }
    JLabel imageLabel;
    JTextArea descriptionArea;
    JPanel centerPanel;
    Vector <Fort> fortlist = new Vector<>();

    public void seedData() {    
    fortlist.add(new Fort(
        "Raigad",
        "Raigad",
        "Raigad Fort, situated in the Mahad region of Maharashtra, served as the majestic capital of the Maratha Empire under Chhatrapati Shivaji Maharaj. Perched at an altitude of approximately 820 meters in the Sahyadri mountain range, it is often referred to as the 'Gibraltar of the East'. The fort is historically significant as the site of Shivaji Maharaj’s coronation in 1674. Notable structures include the Nagarkhana, the massive Maha Darwaza, and the Hirkani Buruj. Accessible via a steep climb of nearly 1,735 steps or a modern ropeway, it remains a symbol of Maratha valor and strategic brilliance.\n\n"+
                        "Location: Mahad, Raigad District, Maharashtra\r\n" + //
                        "Elevation: Approximately 820 meters (2,700 feet) above sea level\r\n" + //
                        "Founder: Originally Morey of Jawali, significantly fortified by Chhatrapati Shivaji Maharaj\r\n" + //
                        "Capital Status: Capital of the Maratha Empire from 1674 to 1689\r\n" + //
                        "Key Architect: Hiroji Indulkar\r\n" + //
                        "Major Landmarks: Nagarkhana, Maha Darwaza, Hirkani Buruj, Balekilla, and Jagdishwar Temple\r\n" + //
                        "Historical Event: Coronation of Chhatrapati Shivaji Maharaj (June 6, 1674)\r\n" + //
                        "Access: 1,735 steps or the Raigad Ropeway\r\n" + //
                        "Nicknames: \"Gibraltar of the East\" and \"King of Forts\"\r\n" + //
                        "Range: Sahyadri Mountain Range",
        "assets/raigad.jpg"));

    fortlist.add(new Fort(
        "Shivneri", 
        "Pune", 
        "Shivneri Fort, located near Junnar in the Pune district of Maharashtra, is eternally celebrated as the birthplace of Chhatrapati Shivaji Maharaj. Built in the 16th century, this triangular hill fort features a robust defensive design with seven massive gates, including the Mana Darwaja and Kulambkat Darwaja. At the heart of the fort lies the Shivai Devi temple, after whom the Emperor was named, and the reconstructed birthplace building. Known for its steep cliffs and strategic positioning, Shivneri also houses the Badami Talav and several ancient rock-cut caves, standing today as a revered site of Maratha heritage.\n\n"+
                        "Location: Junnar, Pune District, Maharashtra\n" + //
                        "Elevation: 1,067 meters (3,500 feet)\n" + //
                        "Significance: Birthplace of Chhatrapati Shivaji Maharaj\n" + //
                        "Key Landmarks: Shivai Devi Temple, Birthplace Pavilion, Badami Talav\n" + //
                        "Gates: Seven massive gates including Mana Darwaja and Kulambkat Darwaja\n" + //
                        "Architecture: Triangular hill fort with steep natural cliffs", 
        "assets/shivneri.jpg"));
    
    fortlist.add(new Fort(
        "Rajgad", 
        "Pune", 
        "Rajgad Fort, located in the Pune district of Maharashtra, served as the first capital of the Maratha Empire for over 25 years. Known as the \"King of Forts,\" it is famous for its massive diameter and complex architecture. The fort is divided into four main sections: the central Balekilla and three prominent suvelas (plateaus) known as Padmavati, Sanjeevani, and Suvela Machi. Its strategic design made it nearly impregnable, providing a secure base for Chhatrapati Shivaji Maharaj’s early administration. Today, it is a premier destination for trekkers exploring the rugged beauty and historical depth of the Sahyadris.\n\n"+"Location: Gunjavane, Pune District, Maharashtra\n" + //
                        "Elevation: 1,376 meters (4,514 feet)\n" + //
                        "Capital Status: First Capital of the Maratha Empire (for 26 years)\n" + //
                        "Main Sections: Padmavati Machi, Sanjeevani Machi, Suvela Machi, and Balekilla\n" + //
                        "Key Features: Massive diameter, rugged topography, and complex fortifications\n" + //
                        "Nicknames: \"King of Forts\"", 
        "assets/rajgad.jpg"));

    fortlist.add(new Fort(
        "Pratapgad", 
        "Satara", 
        "Pratapgad Fort, located in the Satara district near Mahabaleshwar, is a mountain stronghold famous for the historic Battle of Pratapgad in 1659. It was here that Chhatrapati Shivaji Maharaj defeated the formidable Bijapuri general, Afzal Khan, a victory that significantly bolstered the Maratha Empire. The fort is divided into two parts: the Upper Fort (Balekilla) and the Lower Fort. Key landmarks include the temple of Goddess Bhavani, the bronze statue of Shivaji Maharaj, and the Afzal Tower. Surrounded by dense forests and steep valleys, Pratapgad remains a popular destination for its military architecture and panoramic views of the Konkan coast.\n\n"+"Location: Mahabaleshwar, Satara District, Maharashtra\n" + //
                        "Elevation: 1,080 meters (3,540 feet)\n" + //
                        "Historical Event: Battle of Pratapgad (Victory over Afzal Khan, 1659)\n" + //
                        "Key Landmarks: Bhavani Temple, Afzal Tower, Statue of Shivaji Maharaj\n" + //
                        "Sections: Divided into Upper Fort (Balekilla) and Lower Fort\n" + //
                        "Strategic Value: Controlled the mountain passes of Par and Kineshwar",
        "assets/pratapgad.jpg"));

    fortlist.add(new Fort(
        "Sindhudurg", 
        "Sindhudurg", 
        "Sindhudurg Fort is a formidable sea fortress situated on Kurte Island, just off the coast of Malvan in the Konkan region of Maharashtra. Built in the mid-17th century by Chhatrapati Shivaji Maharaj, it was designed to counter the influence of foreign colonial powers and the Siddis of Janjira. The fort's construction is remarkable for its use of over 4,000 mounds of iron in its foundation to withstand the relentless Arabian Sea waves. Spanning 48 acres with massive walls, it houses temples dedicated to Goddess Bhavani and Shivaji Maharaj, as well as several freshwater wells that remain functional today.\n\n"+"Location: Malvan, Sindhudurg District, Maharashtra\n" + //
                        "Type: Sea Fortress (Island Fort)\n" + //
                        "Area: 48 acres\n" + //
                        "Founder: Chhatrapati Shivaji Maharaj (1664)\n" + //
                        "Key Feature: Foundation made using 4,000 mounds of iron\n" + //
                        "Unique Asset: Only temple where Shivaji Maharaj is worshipped as a deity", 
        "assets/Sindhudurg1.jpg"));
    
    fortlist.add(new Fort(
        "Vijaydurg", 
        "Sindhudurg", 
        "Vijaydurg Fort, the oldest fort on the Konkan coast, is a massive sea fortress located at the mouth of the Vaghotan River in Maharashtra. Reconstructed and strengthened by Chhatrapati Shivaji Maharaj, it was a primary naval base for the Maratha Navy. The fort is unique because it is surrounded by the sea on three sides, and its entrance is hidden by a strategic architectural layout. One of its most impressive features is a 122-meter-long underwater stone wall designed to wreck enemy ships before they could reach the shore. Often called the \"Eastern Gibraltar,\" Vijaydurg remains a masterpiece of medieval marine engineering.\n\n"+"Location: Devgad, Sindhudurg District, Maharashtra\n" + //
                        "Type: Sea Fortress\n" + //
                        "Historical Nickname: \"Eastern Gibraltar\"\n" + //
                        "Strategic Feature: 122-meter-long underwater stone wall to trap enemy ships\n" + //
                        "Naval Status: Primary base for the Maratha Navy\n" + //
                        "Unique Aspect: Surrounded by the Arabian Sea on three sides", 
        "assets/vijaydurg.png"));

    fortlist.add(new Fort(
        "Suvarnadurg", 
        "Ratnagiri", 
        "Suvarnadurg, meaning \"Golden Fort,\" is a magnificent sea fortress located on a small island in Harnai, Maharashtra. Originally built by the Adil Shahi dynasty and later captured and strengthened by Chhatrapati Shivaji Maharaj in 1660, it served as a vital naval station for the Maratha Navy to defend the coast against the Siddis and European colonial powers. The fort spans approximately eight acres and is famous for its massive dry-stone walls and hidden entrances. One of its most striking features is the main gate, which is adorned with carvings of a turtle and a tiger. Historically, it was a major stronghold for the famous Maratha Navy Admiral, Kanhoji Angre, serving as a central point for controlling maritime trade along the Konkan coast.\n\n"+"Location: Harnai, Ratnagiri District, Maharashtra\n" + //
                        "Type: Sea Fortress (Island Fort)\n" + //
                        "Purpose: Naval station to counter Siddis and European powers\n" + //
                        "Key Landmarks: Main gate with turtle and tiger carvings\n" + //
                        "Associated Figure: Admiral Kanhoji Angre\n" + //
                        "Area: Approximately 8 acres", 
        "assets/suvarnadurg.jpg"));
    
    fortlist.add(new Fort(
        "Khanderi", 
        "Raigad", 
        "Khanderi Fort is a coastal stronghold situated on an island off the coast of Alibaug in Maharashtra. Built in 1679 under the direction of Chhatrapati Shivaji Maharaj, the fort was strategically positioned to keep a watchful eye on the British in Mumbai and the Siddis of Janjira. Its construction was a feat of defiance, completed despite intense naval opposition from the British. The fort features high, sturdy walls and was once equipped with heavy cannons to guard the surrounding sea lanes. In 1867, a prominent lighthouse was constructed on the island to guide ships navigating the rocky shoreline. Along with its sister fort, Underi, Khanderi remains a significant landmark of Maratha naval history and strategic maritime defense.\n\n"+"Location: Alibaug, Raigad District, Maharashtra\n" + //
                        "Type: Island Fort\n" + //
                        "Construction Date: 1679\n" + //
                        "Purpose: To check British naval influence in Mumbai\n" + //
                        "Key Landmarks: 19th-century lighthouse, heavy cannon emplacements\n" + //
                        "Strategic Rivalry: Faced intense opposition from the British during construction", 
        "assets/khanderi.jpg"));
    
    fortlist.add(new Fort(
        "Lohagad", 
        "Pune", 
        "Lohagad Fort, meaning \"Iron Fort,\" is one of the many hill forts of Maharashtra, situated near the hill station of Lonavala. Perched at an elevation of 1,033 meters, it divides the basins of the Indrayani and Pavana rivers. The fort has a long history, being occupied by several dynasties, but it gained prominence under Chhatrapati Shivaji Maharaj, who captured it in 1648 and used it to store treasury looted from Surat. A unique architectural feature of Lohagad is the **Vinchu Kata** (Scorpion's Tail), a long and narrow fortified spur that extends from the main structure. The fort is also famous for its four massive, well-preserved gates: Ganesh Darwaja, Narayan Darwaja, Hanuman Darwaja, and Maha Darwaja. Its proximity to the Bhaja Caves and its sturdy, \"iron-like\" defenses make it a significant site for both history enthusiasts and trekkers.\n\n"+"Location: Lonavala, Pune District, Maharashtra\n" + //
                        "Elevation: 1,033 meters (3,389 feet)\n" + //
                        "Unique Feature: Vinchu Kata (Scorpion's Tail) long narrow spur\n" + //
                        "Gates: Ganesh, Narayan, Hanuman, and Maha Darwaja\n" + //
                        "Utility: Used to secure treasury and as a strategic hilltop lookout\n" + //
                        "Nearby Attraction: Bhaja Caves", 
        "assets/lohagad.jpg"));
    
    fortlist.add(new Fort(
        "Salhergad", 
        "Nashik", 
        "Salher Fort, located in the Nashik district of Maharashtra, holds the distinction of being the **highest hill fort** in the state, standing at an elevation of 1,567 meters. It was the site of the historic **Battle of Salher** in 1672, a significant open-field engagement where the Maratha forces decisively defeated the Mughal army, marking a major turning point in Maratha history. The fort offers a breathtaking 360-degree view of the Baglan mountain range and features several rock-cut water cisterns, ancient caves, and a temple dedicated to Lord Parshuram at its summit. Due to its extreme height and rugged terrain, it served as a formidable defensive outpost. Today, Salher is a prized destination for trekkers seeking to experience the challenging climbs and the immense historical legacy of the Sahyadri peaks.\n\n"+"Location: Baglan, Nashik District, Maharashtra\n" + //
                        "Elevation: 1,567 meters (5,141 feet)\n" + //
                        "Record: Highest hill fort in Maharashtra\n" + //
                        "Historical Event: Battle of Salher (1672)\n" + //
                        "Key Landmarks: Parshuram Temple, rock-cut water cisterns\n" + //
                        "Range: Selbari-Dolbari Range", 
        "assets/salher.jpg"));

    fortlist.add(new Fort(
        "Panhala", 
        "Kolhapur", 
        "Panhala Fort, located near Kolhapur, is one of the largest and most significant forts in the Deccan. Built between 1175 and 1209 by the Shilahara ruler Bhoja II, it later became a pivotal stronghold for Chhatrapati Shivaji Maharaj. It is famously associated with the **Siege of Panhala** in 1660, where Shivaji Maharaj made a daring escape through a heavy Mughal encirclement to reach Vishalgad, aided by the legendary sacrifice of **Baji Prabhu Deshpande** at Pawankhind. The fort is renowned for its massive size, stretching over 7 kilometers in circumference. Key structures include the **Teen Darwaza**, a sophisticated three-layered entrance, and **Amberkhana**, three enormous granaries capable of storing thousands of pounds of grain. Due to its strategic location overlooking the main trade routes through the Sahyadri mountains, Panhala remained a seat of power for the Maratha Empire for centuries.\n\n"+"Location: Kolhapur District, Maharashtra\n" + //
                        "Circumference: 7 kilometers\n" + //
                        "Historical Event: Siege of Panhala and Shivaji Maharaj's escape to Vishalgad\n" + //
                        "Key Landmarks: Teen Darwaza, Amberkhana (Granaries), Sajja Kothi\n" + //
                        "Architecture: Mix of Maratha, Bijapuri, and Bahamani styles\n" + //
                        "Strategic Value: Guarded the trade routes of the Sahyadri mountains", 
        "assets/panhala.jpg"));

    fortlist.add(new Fort(
        "Gingee", 
        "Villupuram (TN)", 
        "Gingee Fort, often called the **\"Troy of the East\"** by the British, is one of the most impregnable fortresses in India, located in the Villupuram district of Tamil Nadu. Originally built by the Chola dynasty, it was later fortified by the Vijayanagara Empire and became a vital stronghold for the Maratha Empire under Chhatrapati Shivaji Maharaj in 1677. The fort is unique because it spans across three separate hilltops—**Rajagiri, Krishnagiri, and Chandrayandurg**—connected by a massive outer wall. The Rajagiri peak is the most formidable, featuring a narrow bridge over a deep chasm as its only entrance. Key architectural highlights include the seven-story **Kalyana Mahal**, granaries, a gym, and the sacred Chenjiamman Temple. Its strategic design allowed the Marathas to withstand a legendary eight-year siege by the Mughals, cementing its reputation as a masterpiece of military engineering.\n\n"+"Location: Villupuram District, Tamil Nadu\n" + //
                        "Nicknames: \"Troy of the East,\" \"Impregnable Fortress\"\n" + //
                        "Structure: Spans three hills (Rajagiri, Krishnagiri, and Chandrayandurg)\n" + //
                        "Key Landmarks: Kalyana Mahal, Chenjiamman Temple, Prisoner's Well\n" + //
                        "Historical Significance: Stood an 8-year siege against the Mughal Army\n" + //
                        "Southern Capital: Vital stronghold for Maratha expansion in South India", 
        "assets/gingee.jpg"));

    

    

}
    Vector <Question> quizList = new Vector<>();
    public void seedQuiz(){
        quizList.add(new Question("Q1. Which fort is known as the 'Gibraltar of the East'?",
            new String[]{"Shivneri", "Raigad", "Pratapgad", "Lohagad"},1));
        quizList.add(new Question("Q2. Where was Chhatrapati Shivaji Maharaj born?",
            new String[]{"Rajgad", "Panhala", "Shivneri", "Vijaydurg"}, 2));
        quizList.add(new Question("Q3. Which fort features the 'Vinchu Kata' spur?",
            new String[]{"Lohagad", "Salher", "Sindhudurg", "Khanderi"}, 0));
        quizList.add(new Question("Q4. Which fort features as the highest hill fort in Maharashtra?",
            new String[]{"Lohagad", "Salher", "Sindhudurg", "Khanderi"}, 1));
        quizList.add(new Question("Q5. Who was Assosiated with Suvarnadurg- The golden fort?",
            new String[]{"Baji Prabhu Deshpande", "Hiroji Indolkar", "Tanhaji Malusare", "Kanhoji Angre"}, 3));
        
    }
    

    public static void main(String[] args) {
        
        //app.seedData();
        try{
            for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e){

        }
        java.awt.EventQueue.invokeLater(() ->{
            GadlekhApp app = new GadlekhApp();
            app.setVisible(true);
            System.out.println(app.fortlist.size()+" forts of Chhatrapati Shivaji Maharaj are the UNESCO world Heritage sites");
        });
        
        
    }

    
}

class Question {
    String question;
    String[] options;
    int correctIndex;

    public Question(String q, String[] opts, int correct) {
        this.question = q;
        this.options = opts;
        this.correctIndex = correct;
    }
}