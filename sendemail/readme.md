# ![DevSuperior logo](https://raw.githubusercontent.com/devsuperior/bds-assets/main/ds/devsuperior-logo-small.png) Estudo de caso - Padrões de projeto
[DevSuperior - Escola de programação](https://devsuperior.com.br)

[![DevSuperior no Instagram](https://raw.githubusercontent.com/devsuperior/bds-assets/main/ds/ig-icon.png)](https://instagram.com/devsuperior.ig)
[![DevSuperior no Youtube](https://raw.githubusercontent.com/devsuperior/bds-assets/main/ds/yt-icon.png)](https://youtube.com/devsuperior)

## DTO

```json
{
    "fromEmail" : "",
    "fromName" : "",
    "replyTo" : "",
    "to" : "",
    "subject" : "Meu assunto",
    "body" : "Meu conteúdo do email com <strong>palavra forte</strong> destacada.",
    "contentType" : "text/html"
}
```

## Requisito

![Image](https://raw.githubusercontent.com/devsuperior/aula-dp1/main/img/sendgrid.png "SendgridService")

- Simular envio do email no perfil "test" e enviar email real nos demais perfis
