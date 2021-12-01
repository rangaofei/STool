package cn.rangaofei.urltool.time;

import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePanel extends JPanel {

    private JButton timerToggle;
    private JButton timerLabel;

    private ComboBox<TimeUnit> unitComboBox1;
    private JBTextField time1;
    private Button translate1;
    private JBTextField timeStamp1;

    private ComboBox<TimeUnit> unitComboBox2;
    private JBTextField time2;
    private Button translate2;
    private JBTextField timeStamp2;
    private Timer timer;

    public TimePanel() {
        initView();
    }

    private void initView() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        initTimer();
        this.add(Box.createVerticalStrut(20));
        initTimeStampToTime();
        this.add(Box.createVerticalStrut(20));
        initTimeToTimeStamp();
    }

    private void initTimer() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        jPanel.add(new JBLabel("当前时间"));
        jPanel.add(Box.createHorizontalStrut(10));
        timerLabel = new JButton(String.valueOf(System.currentTimeMillis()));
        timerLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeStamp1.setText(timerLabel.getText());
            }
        });
        jPanel.add(timerLabel);
        jPanel.add(Box.createHorizontalGlue());
        jPanel.add(Box.createHorizontalStrut(10));
        timerToggle = new JButton("停止");
        timerToggle.addActionListener(e -> toggleTimer());
        jPanel.add(timerToggle);
        startTimer();
        jPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(jPanel);
    }

    private ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timerLabel.setText(String.valueOf(e.getWhen()));

        }
    };

    private void toggleTimer() {
        if (timer == null || !timer.isRunning()) {
            startTimer();
        } else {
            stopTimer();
        }
        timerToggle.setText(timer.isRunning() ? "停止" : "启动");
    }

    private void startTimer() {
        if (timer == null) {
            timer = new Timer(500, null);
            timer.setRepeats(true);
        }
        timer.addActionListener(actionListener);
        timer.start();
    }

    private void stopTimer() {
        if (timer == null) {
            return;
        }
        timer.removeActionListener(actionListener);
        timer.stop();
    }

    private void initTimeStampToTime() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(initTimeStampToTimeTop());
        this.add(Box.createVerticalStrut(10));
        jPanel.add(initTimeStampToTimeCenter());
        this.add(Box.createVerticalStrut(10));
        jPanel.add(initTimeStampToTimeBottom());
        jPanel.setBorder(createTitledBorder("时间戳转时间"));
        this.add(jPanel);
    }


    private Box initTimeStampToTimeTop() {
        Box box = Box.createHorizontalBox();
        box.add(new JBLabel("时间戳   "));
        box.add(Box.createHorizontalStrut(10));
        timeStamp1 = new JBTextField();
        box.add(timeStamp1);
        return box;
    }

    private Box initTimeStampToTimeCenter() {
        Box box = Box.createHorizontalBox();
        JBLabel label = new JBLabel("转换选项");
        box.add(label);
        box.add(Box.createHorizontalStrut(10));
        unitComboBox1 = createUnitComboBox();
        box.add(unitComboBox1);
        box.add(Box.createHorizontalStrut(10));
        translate1 = new Button("转换");
        translate1.addActionListener(e -> {
            String timeStampStr = timeStamp1.getText();
            TimeUnit tu = (TimeUnit) unitComboBox1.getSelectedItem();
            String result = TimeTool.timeStampToTime(timeStampStr, tu);
            time1.setText(result);
        });
        box.add(translate1);
        return box;
    }

    private Box initTimeStampToTimeBottom() {
        Box box = Box.createHorizontalBox();
        box.add(new JBLabel("北京时间"));
        box.add(Box.createHorizontalStrut(10));
        time1 = new JBTextField();
        box.add(time1);
        return box;
    }


    private ComboBox<TimeUnit> createUnitComboBox() {
        ComboBox<TimeUnit> comboBox = new ComboBox<>();
        for (TimeUnit unit : TimeUnit.values()) {
            comboBox.addItem(unit);
        }
        return comboBox;
    }


    private void initTimeToTimeStamp() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        jPanel.add(initTimeToTimeStampTop());
        this.add(Box.createVerticalStrut(10));
        jPanel.add(initTimeToTimeStampCenter());
        this.add(Box.createVerticalStrut(10));
        jPanel.add(initTimeToTimeStampBottom());
        jPanel.setBorder(createTitledBorder("时间转时间戳"));
        this.add(jPanel);
    }


    private Border createTitledBorder(String title) {
        Border lineBorder = BorderFactory.createLineBorder(JBColor.BLACK, 1, true);
        Border titleBorder = BorderFactory.createTitledBorder(lineBorder, title);
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        return BorderFactory.createCompoundBorder(titleBorder, emptyBorder);
    }

    private Box initTimeToTimeStampTop() {
        Box box = Box.createHorizontalBox();
        box.add(new JBLabel("北京时间"));
        box.add(Box.createHorizontalStrut(10));
        time2 = new JBTextField();
        time2.setText(time1.getText());
        box.add(time2);
        return box;
    }

    private Box initTimeToTimeStampCenter() {
        Box box = Box.createHorizontalBox();
        JBLabel label = new JBLabel("转换选项");
        box.add(label);
        box.add(Box.createHorizontalStrut(10));
        unitComboBox2 = createUnitComboBox();
        box.add(unitComboBox2);
        box.add(Box.createHorizontalStrut(10));
        translate2 = new Button("转换");
        translate2.addActionListener(e -> {
            String time = time2.getText();
            TimeUnit tu = (TimeUnit) unitComboBox2.getSelectedItem();
            timeStamp2.setText(String.valueOf(TimeTool.timeToTimeStamp(time, tu)));
        });
        box.add(translate2);
        return box;
    }

    private Box initTimeToTimeStampBottom() {
        Box box = Box.createHorizontalBox();
        box.add(new JBLabel("时间戳   "));
        box.add(Box.createHorizontalStrut(10));
        timeStamp2 = new JBTextField();
        box.add(timeStamp2);
        return box;
    }
}
