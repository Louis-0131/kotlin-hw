package com.example.lab3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var ed_name: EditText
    private lateinit var tv_text: TextView
    private lateinit var tv_name: TextView
    private lateinit var tv_winner: TextView
    private lateinit var tv_mmora: TextView
    private lateinit var tv_cmora: TextView
    private lateinit var btn_scissor: RadioButton
    private lateinit var btn_stone: RadioButton
    private lateinit var btn_paper: RadioButton
    private lateinit var btn_mora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_name = findViewById(R.id.ed_name)

        tv_text = findViewById(R.id.tv_text)
        tv_name = findViewById(R.id.tv_name)
        tv_winner = findViewById(R.id.tv_winner)
        tv_mmora = findViewById(R.id.tv_mmora)
        tv_cmora = findViewById(R.id.tv_cmora)

        btn_scissor = findViewById(R.id.btn_scissor)
        btn_stone = findViewById(R.id.btn_stone)
        btn_paper = findViewById(R.id.btn_paper)

        btn_mora = findViewById(R.id.btn_mora)

        btn_mora.setOnClickListener(View.OnClickListener {
            if (ed_name.length() < 1) {
                tv_text.setText("請輸入玩家姓名")
            } else {
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()))

                if (btn_scissor.isChecked()) {
                    tv_mmora.setText("我方出拳\n剪刀")
                } else if (btn_stone.isChecked()) {
                    tv_mmora.setText("我方出拳\n石頭")
                } else {
                    tv_mmora.setText("我方出拳\n布")
                }
                val computer_random = (Math.random() * 3).toInt()
                if (computer_random == 0) {
                    tv_cmora.setText("電腦出拳\n剪刀")
                } else if (computer_random == 1) {
                    tv_cmora.setText("電腦出拳\n石頭")
                } else {
                    tv_cmora.setText("電腦出拳\n布")
                }

                if ((btn_scissor.isChecked() && computer_random == 2) ||
                    (btn_stone.isChecked() && computer_random == 0) ||
                    (btn_paper.isChecked() && computer_random == 1)
                ) {
                    tv_winner.setText(
                        """
    勝利者
    ${ed_name.getText()}
    """.trimIndent()
                    )
                    tv_text.setText("恭喜您獲勝了！！！")
                } else if ((btn_scissor.isChecked() && computer_random == 1) ||
                    (btn_stone.isChecked() && computer_random == 2) ||
                    (btn_paper.isChecked() && computer_random == 0)
                ) {
                    tv_winner.setText("勝利者\n電腦")
                    tv_text.setText("可惜，電腦獲勝了！")
                } else {
                    tv_winner.setText("勝利者\n平手")
                    tv_text.setText("平局，請再試一次！")
                }
            }
        })
    }
}