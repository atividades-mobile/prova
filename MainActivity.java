// MainActivity.java
package com.example.investmentcalculator;

// Importando bibliotecas necessárias para o funcionamento do aplicativo
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// Definindo a classe principal do aplicativo, que estende AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Declaração dos componentes de interface que serão usados para capturar dados e exibir o resultado
    private EditText editTextValorInicial;  // Campo de texto para o valor inicial do investimento
    private EditText editTextTaxaJuros;     // Campo de texto para a taxa de juros anual
    private EditText editTextAnos;          // Campo de texto para o número de anos do investimento
    private TextView textViewResultado;     // Campo de texto para exibir o resultado do cálculo

    // Método onCreate é chamado quando a atividade é criada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Define o layout da atividade como o arquivo activity_main.xml

        // Inicializando os componentes de interface ligando-os aos IDs definidos no layout XML
        editTextValorInicial = findViewById(R.id.editTextValorInicial); // Ligando o campo de valor inicial
        editTextTaxaJuros = findViewById(R.id.editTextTaxaJuros);       // Ligando o campo de taxa de juros anual
        editTextAnos = findViewById(R.id.editTextAnos);                 // Ligando o campo de anos
        textViewResultado = findViewById(R.id.textViewResultado);       // Ligando a área de exibição do resultado
        Button buttonCalcular = findViewById(R.id.buttonCalcular);      // Ligando o botão "Calcular Rendimento"

        // Configurando o evento de clique do botão
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularRendimento(); // Chama o método calcularRendimento quando o botão é clicado
            }
        });
    }

    // Método para calcular o rendimento com base em juros compostos
    private void calcularRendimento() {
        // Obtendo valores digitados pelo usuário e convertendo-os para tipos numéricos adequados
        double valorInicial = Double.parseDouble(editTextValorInicial.getText().toString()); // Converte o valor inicial para double
        double taxaJuros = Double.parseDouble(editTextTaxaJuros.getText().toString()) / 100; // Converte a taxa de juros para double e divide por 100 (transforma em decimal)
        int anos = Integer.parseInt(editTextAnos.getText().toString());                      // Converte o número de anos para int

        // Calculando o valor final do investimento usando a fórmula de juros compostos
        // Fórmula: Valor Final = Valor Inicial * (1 + Taxa Anual) ^ Anos
        double valorFinal = valorInicial * Math.pow(1 + taxaJuros, anos); // Math.pow realiza a exponenciação

        // Exibindo o resultado formatado na TextView (área de exibição de texto)
        // %.2f formata o valor final para duas casas decimais
        textViewResultado.setText(String.format("Resultado: R$ %.2f", valorFinal));
    }
}
