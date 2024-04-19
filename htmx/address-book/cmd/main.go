package main

import (
	"html/template"
	"io"
	"net/http"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
)

type Templates struct {
	templates *template.Template
}

func (t *Templates) Render(w io.Writer, name string, data interface{}, c echo.Context) error {
	return t.templates.ExecuteTemplate(w, name, data)
}

func NewTemplates() *Templates {
	return &Templates{
		templates: template.Must(template.ParseGlob("views/*.html")),
	}
}

type Contact struct {
	Name  string
	Phone string
	Email string
}

type Contacts struct {
	Contacts []Contact
}

func main() {
	e := echo.New()
	e.Renderer = NewTemplates()
	e.Use(middleware.Logger())

	contacts := Contacts{
		Contacts: []Contact{
			{"Lindsay", "913-620-2557", "lindsaygharst@gmail.com"},
			{"Cori", "816-405-2680", "corimroz@gmail.com"},
		},
	}

	e.GET("/", func(c echo.Context) error {
		return c.Render(http.StatusOK, "index", contacts)
	})

	e.POST("/contact", func(c echo.Context) error {
		contact := Contact{
			c.FormValue("name"),
			c.FormValue("phone"),
			c.FormValue("email"),
        }

		contacts.Contacts = append(contacts.Contacts, contact)
		return c.Render(http.StatusOK, "contact", contact)
	})

	e.Logger.Fatal(e.Start(":42069"))
}
