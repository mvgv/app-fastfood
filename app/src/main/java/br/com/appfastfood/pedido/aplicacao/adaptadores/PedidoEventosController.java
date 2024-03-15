package br.com.appfastfood.pedido.aplicacao.adaptadores;


import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.MensagemSNS;
import br.com.appfastfood.pedido.usecase.portas.PagamentoServico;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@RestController
public class PedidoEventosController {

        private final PagamentoServico pagamentoServico;

        public PedidoEventosController(PagamentoServico pagamentoServico) {
            this.pagamentoServico = pagamentoServico;
        }

        @PostMapping("/pedido-criado")
        public void handleSnsMessage(@RequestBody String notification) {
            ObjectMapper objectMapper = new ObjectMapper();
            MensagemSNS snsMessage;
            try {
                snsMessage = objectMapper.readValue(notification, MensagemSNS.class);
                // Agora você pode verificar o tipo de mensagem e executar a ação apropriada
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error deserializing SNS message", e);
            }

            switch (snsMessage.getType()) {
                case "SubscriptionConfirmation":
                    // Lógica para confirmar a inscrição
                    String subscribeURL = snsMessage.getSubscribeURL();
                    System.out.println("Received subscription confirmation request. URL: " + subscribeURL);
                    HttpClient client = HttpClient.newHttpClient();
                    URI uri = URI.create(subscribeURL);
                    System.out.println("PATH URL: " + uri.getPath());
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(subscribeURL))
                            .GET() // Método GET para confirmar a inscrição
                            .build();
                    try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        if (response.statusCode() == 200) {
                            System.out.println("Subscription confirmed successfully.");
                        } else {
                            System.out.println("Failed to confirm subscription. Response code: " + response.statusCode());
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Error confirming subscription: " + e.getMessage());
                    }

                    break;
                case "Notification":
                    // Lógica para tratar mensagens recebidas
                    System.out.println("Received message: " + snsMessage.getMessage());
                    pagamentoServico.efetuaPagamento("Valor");

                    break;
                case "UnsubscribeConfirmation":
                    // Lógica para tratar confirmações de cancelamento de inscrição
                    System.out.println("Unsubscribed from topic");
                    break;
                default:
                    System.out.println("Unknown message type: " + snsMessage.getType());
                    break;
            }
        }


    @PostMapping("/efetua-pagamento")
    public void handlePaySnsMessage(@RequestBody String notification) {
        ObjectMapper objectMapper = new ObjectMapper();
        MensagemSNS snsMessage;
        try {
            snsMessage = objectMapper.readValue(notification, MensagemSNS.class);
            // Agora você pode verificar o tipo de mensagem e executar a ação apropriada
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing SNS message", e);
        }

        switch (snsMessage.getType()) {
            case "SubscriptionConfirmation":
                // Lógica para confirmar a inscrição
                String subscribeURL = snsMessage.getSubscribeURL();
                System.out.println("Received subscription confirmation request. URL: " + subscribeURL);
                HttpClient client = HttpClient.newHttpClient();
                URI uri = URI.create(subscribeURL);
                System.out.println("PATH URL: " + uri.getPath());
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(subscribeURL))
                        .GET() // Método GET para confirmar a inscrição
                        .build();
                try {
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    if (response.statusCode() == 200) {
                        System.out.println("Subscription confirmed successfully.");
                    } else {
                        System.out.println("Failed to confirm subscription. Response code: " + response.statusCode());
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("Error confirming subscription: " + e.getMessage());
                }

                break;
            case "Notification":
                // Lógica para tratar mensagens recebidas
                System.out.println("Received message: " + snsMessage.getMessage());
                break;
            case "UnsubscribeConfirmation":
                // Lógica para tratar confirmações de cancelamento de inscrição
                System.out.println("Unsubscribed from topic");
                break;
            default:
                System.out.println("Unknown message type: " + snsMessage.getType());
                break;
        }
    }
    }
