package main

import (
	"context"
	"log"
	"os"
	"strings"

	"github.com/Azure/azure-sdk-for-go/sdk/messaging/azservicebus"
)

func main() {
    client := CreateClient()

    if (os.Args[1] == "send") {
        message := strings.Join(os.Args[1:], " ")
        SendMessage(message, client)
    } else if (os.Args[1] == "receive") {
        message := ReceiveMessage(client)
        log.Println(message)
    } else {
        log.Fatal("Invalid verb")
    }
}

func CreateClient() *azservicebus.Client {
    connectionString, ok := os.LookupEnv("SERVICEBUS_CONNECTIONSTRING")
    if !ok {
        log.Fatal("SERVICEBUS_CONNECTIONSTRING environment variable not set")
    }

    client, err := azservicebus.NewClientFromConnectionString(connectionString, nil)
    if err != nil {
        log.Fatal(err)
    }

    return client
}

func SendMessage(message string, client *azservicebus.Client) {
    sender, err := client.NewSender("hello-go-world", nil)
    if err != nil {
        log.Fatal(err)
    }
    defer sender.Close(context.TODO())

    sbMessage := &azservicebus.Message{
        Body: []byte(message),
    }

    err = sender.SendMessage(context.Background(), sbMessage, nil)
    if err != nil {
        log.Fatal(err)
    }
}

func SendMessageBatch(messages []string, client *azservicebus.Client) {
    sender, err := client.NewSender("hello-go-world", nil)
    if err != nil {
        log.Fatal(err)
    }
    defer sender.Close(context.TODO())

    batch, err := sender.NewMessageBatch(context.TODO(), nil)
    if err != nil {
        log.Fatal(err)
    }

    for _, message := range messages {
        if err := batch.AddMessage(&azservicebus.Message{Body: []byte(message)}, nil); err != nil {
            log.Fatal(err)
        }
    }

    err = sender.SendMessageBatch(context.TODO(), batch, nil)
    if err != nil {
        log.Fatal(err)
    }
}

func ReceiveMessage(client *azservicebus.Client) string {
    receiver, err := client.NewReceiverForSubscription("hello-go-world", "hello-go-world-svc", nil)
    if err != nil {
        log.Fatal(err)
    }
    defer receiver.Close(context.TODO())

    messages, err := receiver.ReceiveMessages(context.TODO(), 1, nil)
    if err != nil {
        log.Fatal(err)
    }

    err = receiver.CompleteMessage(context.TODO(), messages[0], nil)
    if err != nil {
        log.Fatal(err)
    }

    return string(messages[0].Body)
}
