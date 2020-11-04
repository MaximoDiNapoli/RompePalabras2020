from tkinter import *      
from tkinter import scrolledtext
import random
from tkinter import messagebox

import requests
from getpass import getpass


#r = requests.post("http://127.0.0.1:4567/AgregarUsuario", params = {
 #       "username": "Elpibe",
  #      "email": "ElPibe@gmail.com"
   # }) 

#url = "http://127.0.0.1:4567/AgregarUsuario"
#cabecera1 = {'Content-type': 'application/json'}
#datos = '{"username": "ElPibe", "email": "ElPibe@gmail.com" }'
#solicitud = requests.post(url, headers = cabecera1, data = datos)
#if solicitud.status_code == 200:
#    print(solicitud.text)



class App():
    def __init__(self, root):
        self.root = root
        self.nombrus = ""
        self.email = ""
        self.Przyjaciele = ["FriedrichPrussen74", "CarolusAdolphusSweedenForTheWin", "MustafaPashaKebab67"]
        self.nombrianni = "Nombre:" + self.nombrus
        self.setPreguntas = [0, 1, 2, 3, 4]
        self.pregunta = ["Co kolorowy jest czerwony?", "Carlos Martel evito que los bereberes entraran en...?", "La cacion One Way Or Another pertenece a...?", "Cuantos protones tiene el litio?", "Que libreria conecta sencillamente Python y MongoDb sin utilizar una API?"]
        self.setRespuestas = ["To nie", "To tez nie", "To mniej", "To tak"], ["Francia", "Alemania", "Brazil", "Marruecos"], ["Blondie", "Depeche Mode", "Ensiferum", "Bjork"], ["10", "21", "13", "3"], ["PyMongo", "MongoPy", "PyMo", "MongoConnect"]

        self.correcta = [4, 1, 1, 4, 1]      
        self.puntaje = 0
        self.terminado = 0
        self.login()



    def login(self):    
        self.pantallaLogin = Frame()
        self.canvas = Canvas(self.pantallaLogin, width = 220, height = 210)   
        self.img = PhotoImage(file="PalabraRota.png")      
        self.canvas.create_image(30,30, anchor=NW, image=self.img)
        self.text3 = Text(self.pantallaLogin, width = 35, height = 1)
        self.text4 = Text(self.pantallaLogin, width = 35, height = 1)
        self.labelu4 = Label(self.pantallaLogin, text="Nombre:")
        self.text4.insert(INSERT, "")
        self.labelu5 = Label(self.pantallaLogin, text="Email:")
        self.text3.insert(INSERT, "")
        self.butony = Button(self.pantallaLogin, text="Ingresar", width = 20, command=self.VerificarCuenta)
        self.butony4 = Button(self.pantallaLogin, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.canvas.pack()  
        self.labelu4.pack()    
        self.text3.pack()
        self.labelu5.pack()
        self.text4.pack()
        self.butony.pack()
        self.butony4.pack()
        self.pantallaLogin.pack()
        self.labeluR = Label(self.pantallaLogin, text="Usuario no encontrado, por favor reintentelo o cree una cuenta")


    def menu(self):
        self.pantallaPrincipal = Frame()
        self.labeluN2 = Label(self.pantallaPrincipal, text= self.nombrianni)
        self.labelu = Label(self.pantallaPrincipal, text="Informacion de Usuario:")
        
        self.labelu.grid(column=1, row=2, sticky = S)
        self.labeluN2.grid(column=1, row=3)
        self.labelu2 = Label(self.pantallaPrincipal, text="Przyjaciele:")
        self.labelu2.grid(column=1, row=4)
        self.nanie = 5
        self.menuJuego = Menu(self.pantallaPrincipal)
        self.jugarAmigos = Menu(self.menuJuego)
        for nombranie in self.Przyjaciele:
            self.labeluP = Label(self.pantallaPrincipal, text= nombranie)
            self.labeluP.grid(column=1, row=self.nanie)
            self.jugarAmigos.add_command(label = nombranie, command = self.BuscarPartida)
            self.nanie = self.nanie + 1
            
            pass
        self.menuJuego.add_cascade(label = "Jugar con", menu = self.jugarAmigos)
        self.root.config(menu = self.menuJuego)
        self.butony2 = Button(self.pantallaPrincipal, text="Buscar Partida", width = 20, command=self.BuscarPartida)
        self.butony2.grid(column=0, row=3)
        self.butony3 = Button(self.pantallaPrincipal, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.butony3.grid(column=0, row=4)


    def partida(self):
        self.numeroR = random.choice(self.setPreguntas)
        self.pantallaDeJuego = Frame()
        self.labelu = Label(self.pantallaDeJuego, text = self.pregunta[self.numeroR])
        self.labelu.grid(column=2, row=0)
        self.butony1 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][0], width = 20, height = 2, bg = "blue", command= (lambda: (self.resolverRespuesta(1))))
        self.butony2 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][1], width = 20, height = 2, bg = "green", command= (lambda: (self.resolverRespuesta(2))))
        self.butony3 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][2], width = 20, height = 2, bg = "yellow", command= (lambda: (self.resolverRespuesta(3))))
        self.butony4 = Button(self.pantallaDeJuego, text= self.setRespuestas[self.numeroR][3], width = 20, height = 2, bg = "red", command= (lambda: (self.resolverRespuesta(4))))

        self.butony1.grid(column=1, row=1)
        self.butony2.grid(column=1, row=2)
        self.butony3.grid(column=3, row=1)
        self.butony4.grid(column=3, row=2)
        
        


    def resultadoP(self):
        self.pantallaDeResultado = Frame()
        self.butonia = Button(self.pantallaDeResultado, text= "Volver a jugar", width = 20, bg = "green", command=self.VolverAJugar)
        self.butonia2 = Button(self.pantallaDeResultado, text= "Volver al menu", width = 20, bg = "red", command=self.VolverAlMenu)
        
        self.labelu = Label(self.pantallaDeResultado, text = "Puntuacion: " + self.puntaje.__str__())
        self.puntaje = 0
        self.labelu.grid(column=1, row=1)
        self.butonia.grid(column = 0, row = 2)
        self.butonia2.grid(column = 2, row = 2)
    
    def SalirDeLaApp(self):
        self.root.destroy()
        
    def VerificarCuenta(self):
        self.labeluR.destroy()
        url = "http://127.0.0.1:4567/comprobarExistenciaDeUnUsuario"
        self.nombrus = self.text3.get("1.0", "end-1c")
        self.email = self.text4.get("1.0", "end-1c")
        cabecera1 = {'Content-type': 'application/json'}
        datos = '{"username": %s, "email": %s }' % (self.nombrus, self.email)
        solicitud = requests.post(url, headers = cabecera1, data = datos)
        if solicitud.status_code == 200:
            print(solicitud.text)
            if solicitud.text == "true":
                self.pantallaLogin.destroy()
                self.menu()
                self.pantallaPrincipal.pack()
                pass
            else:
                self.labeluR = Label(self.pantallaLogin, text="Usuario no encontrado, por favor reintentelo o cree una cuenta")
                self.labeluR.pack()
                
                pass
        

        
    def BuscarPartida(self):
        self.pantallaPrincipal.destroy()
        self.partida()
        self.pantallaDeJuego.pack()




    def resolverRespuesta(self, seleccion):
        if self.terminado == 0:
            if seleccion == self.correcta[self.numeroR]:
                self.puntaje = self.puntaje + 1
                self.pantallaDeJuego.destroy()
                if self.puntaje == 3:
                    self.resultadoP()
                    self.pantallaDeResultado.pack()
                    self.mandarResultado()
                    self.puntaje = 0
                    pass
                else:
                    self.partida()
                    self.pantallaDeJuego.pack()
                    pass
                pass
            else:
                self.puntaje = self.puntaje - 1
                self.pantallaDeJuego.destroy()
                self.partida()
                self.pantallaDeJuego.pack()
                pass
        pass
        
    def mandarResultado(self):
        pass


    def VolverAJugar(self):
        self.pantallaDeResultado.destroy()
        self.partida()
        self.pantallaDeJuego.pack()

        pass

    def VolverAlMenu(self):
        self.pantallaDeResultado.destroy()
        self.menu()
        self.pantallaPrincipal.pack()
        pass



















root = Tk()
app = App(root)


mainloop() 