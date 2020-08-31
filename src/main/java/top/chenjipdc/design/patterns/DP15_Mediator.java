package top.chenjipdc.design.patterns;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/31 9:42 上午
 */
public class DP15_Mediator {
    abstract static class Component {

        private Mediator mediator;

        void setMediator(Mediator mediator) {

            this.mediator = mediator;
        }

        public void change() {
            mediator.componentChanged(this);
        }
        public abstract void update();
    }


    static class Button extends Component{

        @Override
        public void update() {
            System.out.println("button do nothing");
        }

        public void click(){
            System.out.println("button click");
        }
    }

    static class Label extends Component {

        @Override
        public void update() {
            System.out.println("label update");
        }
    }

    static class TextView extends Component {

        @Override
        public void update() {
            System.out.println("text view update");
        }
    }

    static class TextField extends Component {

        @Override
        public void update() {
            System.out.println("text field update");
        }
    }

    static class CheckBox extends Component {

        @Override
        public void update() {
            System.out.println("check box do nothing");
        }

        public void select() {
            System.out.println("check box select");
        }
    }


    interface Mediator {
        void componentChanged(Component component);

    }

    @Setter
    @Getter
    static class ChaosMediator implements Mediator {

        private Button button;
        private Label label;
        private TextView textView;
        private TextField textField;
        private CheckBox checkBox;

        @Override
        public void componentChanged(Component component) {
            if (component == null){
                return;
            }

            if (component == button) {
                button.click();
                textView.update();
                label.update();
            }else if (component == checkBox) {
                label.update();
                checkBox.select();
                textField.update();
            }
        }
    }

}
