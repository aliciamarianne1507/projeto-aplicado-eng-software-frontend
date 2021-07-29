package com.example.frontend.produto.editarProduto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.frontend.R;
import com.example.frontend.U;
import com.example.frontend.produto.Produto;

import org.json.JSONException;
import org.json.JSONObject;

public class EditarProduto extends AppCompatActivity {
    private RequestQueue queue;
    private Button editarProduto;
    private EditText codProduto;
    private EditText nomeNovoProduto,quantidadeNovoProduto,precoNovoProduto;
    private TextView titleNomeProduto, titleCodigoProduto;
    private TextView titleQuantidadeProduto, titlePrecoProduto;
    private TextView quantidadeProduto, precoProduto;
    private TextView codigoProduto, nomeProduto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);
        components();
        search();
    }

    @SuppressLint("WrongViewCast")
    private void components(){
        queue = Volley.newRequestQueue(this);
        editarProduto = findViewById(R.id.edit_product);
        nomeNovoProduto = findViewById(R.id.editado_produto_nome);
        quantidadeNovoProduto = findViewById(R.id.editado_produto_quantidade);
        precoNovoProduto = findViewById(R.id.editado_produto_preco);
        codProduto = findViewById(R.id.cod_produto);
        codigoProduto = findViewById(R.id.codigo_produto);
        nomeProduto = findViewById(R.id.nome_produto);
        quantidadeProduto = findViewById(R.id.quantidade_produto);
        precoProduto = findViewById(R.id.preco_produto);
        titleCodigoProduto = findViewById(R.id.title_codigo_produto);
        titleNomeProduto = findViewById(R.id.title_nome_produto);
        titlePrecoProduto=findViewById(R.id.title_preco_produto);
        titleQuantidadeProduto = findViewById(R.id.title_quantidade_produto);


    }
    private void search(){
        editarProduto.setOnClickListener(v -> buscarCategory());

    }
    private void buscarCategory(){
        JSONObject postData = new JSONObject();
        try{
            postData.put("codigo_produto", codProduto.getText());
            postData.put("name_produto", nomeNovoProduto.getText());
            postData.put("quantidade_produto",quantidadeNovoProduto.getText());
            postData.put("price_produto",precoNovoProduto.getText());
        }catch (JSONException e){
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                U.BASE_URL + "/produto",
                postData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            Produto produto = new Produto(
                                    response.getString("name_produto"),
                                    response.getString("codigo_produto"),
                                    response.getInt("quantidade_produto"),
                                    response.getDouble("price_produto"),
                                    response.getString("created_at"),
                                    response.getString("updated_at")

                            );
                            setComponents(produto);

                        } catch (JSONException e) {
                            System.out.println(response);
                            e.printStackTrace();
                            titleNomeProduto.setText("Produto não encontrado");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        queue.add(request);
    }

    private void setComponents(Produto produto){
        String quantidade = String.valueOf(produto.getQuantidade_produto());
        String preco = String.valueOf(produto.getPrice_produto());
        codigoProduto.setText(produto.getCodigo_produto());
        nomeProduto.setText(produto.getNome_produto());
        quantidadeProduto.setText(quantidade);
        precoProduto.setText(preco);
        titleCodigoProduto.setText(R.string.codigoprodutotitle);
        titleNomeProduto.setText(R.string.nomeprodutotitle);
        titlePrecoProduto.setText(R.string.precoprodutotitle);
        titleQuantidadeProduto.setText(R.string.quantidadeprodutostitle);
    }
}
