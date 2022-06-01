/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsipbo;

/**
 *
 * @author ASUS
 */
public class MVC {
    public void menu(){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
    }
}
