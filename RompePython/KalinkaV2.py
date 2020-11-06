from tkinter import *      
from tkinter import scrolledtext
import random
from tkinter import messagebox

import requests
from getpass import getpass

#{
#        "player1_id": 2,
#        "player2_id": 3
#   }

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
        self.labeluN2 = Label(self.pantallaPrincipal, text= self.nombreLogueado)
        self.labelu = Label(self.pantallaPrincipal, text="Informacion de Usuario:")
        self.labelu.grid(column=1, row=1, sticky = S)
        self.labeluN2.grid(column=1, row=2)
        self.menuJuego = Menu(self.pantallaPrincipal)
        self.jugarAmigos = Menu(self.menuJuego)
        for nombranie in self.Przyjaciele:
            if nombranie.isdigit():
                nombreAmigo = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = (nombranie))).text
                self.jugarAmigos.add_command(label = nombreAmigo, command = (lambda: (self.BuscarPartida(int((requests.post("http://127.0.0.1:4567/buscarIdPorNombre", headers = {'Content-type': 'application/json'}, data = (nombreAmigo))).text)))))
                pass
            pass
        self.menuJuego.add_cascade(label = "Jugar con", menu = self.jugarAmigos)
        self.root.config(menu = self.menuJuego)
        self.butony3 = Button(self.pantallaPrincipal, text="Salir", width = 20, command=self.SalirDeLaApp)
        self.butony3.grid(column=0, row=1)
        self.butony4 = Button(self.pantallaPrincipal, text="Ver Partidas Activas", width = 20, command=self.irAPartidasSinTemrinar)
        self.butony4.grid(column=0, row=2)


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
        
    def partidasSinTerminar(self):
        self.pantallaPartidas = Frame()
        self.labeluS = Label(self.pantallaPartidas, text = "Partidas sin terminar")
        self.labeluS.pack()
        idpartidas = (requests.post("http://127.0.0.1:4567/partidasDeUnUsuarioSinTerminar", headers = {'Content-type': 'application/json'}, data = str(self.idLogueado))).text
        for idpartida in idpartidas:
            if idpartida.isdigit():
                idParticipantes = (requests.post("http://127.0.0.1:4567/obtenerIdsUsuariosGame", headers = {'Content-type': 'application/json'}, data = (idpartida))).text
                print(idParticipantes + "id")
                nombreContrincante1 = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = (idParticipantes[0]))).text
                print(nombreContrincante1 + "con1")
                nombreContrincante2 = (requests.post("http://127.0.0.1:4567/buscarNombrePorId", headers = {'Content-type': 'application/json'}, data = (idParticipantes[1]))).text
                print(nombreContrincante2 + "con2")
                self.labeluS2 = Label(self.pantallaPartidas, text = (nombreContrincante1 +  " vs " + nombreContrincante2))
                self.labeluS2.pack()
                pass
            pass
        
        


    def resultadoP(self):
        self.pantallaDeResultado = Frame()
        self.butonia = Button(self.pantallaDeResultado, text= "Volver a jugar", width = 20, bg = "green", command=self.VolverAJugar)
        self.butonia2 = Button(self.pantallaDeResultado, text= "Volver al menu", width = 20, bg = "red", command=self.VolverAlMenu)
        self.labelu = Label(self.pantallaDeResultado, text = "Puntuacion: " )
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
                self.idLogueado = requests.post("http://127.0.0.1:4567/buscarIdPorNombre", headers = {'Content-type': 'application/json'}, data = (self.nombrus))
                self.Przyjaciele = (requests.post("http://127.0.0.1:4567/buscarIdPorDocument", headers = {'Content-type': 'application/json'}, data = (self.nombrus))).text
                
                self.idLogueado = int(self.idLogueado.text)
                print(self.idLogueado)
                print(self.Przyjaciele)
                self.nombreLogueado = self.nombrus
                self.pantallaLogin.destroy()
                self.menu()
                self.pantallaPrincipal.pack()
                pass
            else:
                self.labeluR = Label(self.pantallaLogin, text="Usuario no encontrado, por favor reintentelo o cree una cuenta")
                self.labeluR.pack()
                
                pass
        

        
    def BuscarPartida(self, idJugador2):
        self.jugador2 = idJugador2
        self.pantallaPrincipal.destroy()
        self.idPartidaActualSTR = (requests.post("http://127.0.0.1:4567/agregarGame", headers = {'Content-type': 'application/json'}, data = '{"player1_id": %s, "player2_id": %s }' % (self.idLogueado, idJugador2))).text
        self.idPartidaActual = int(self.idPartidaActualSTR) - 1
        self.partida()
        self.pantallaDeJuego.pack()




    def resolverRespuesta(self, seleccion):
        print(self.idPartidaActual)
        self.terminado = (requests.post("http://127.0.0.1:4567/cerrarPartida", headers = {'Content-type': 'application/json'}, data = str(self.idPartidaActual))).text
        print(type(self.terminado))
        arrayPartida = [str(self.idPartidaActual), str(self.idLogueado)]
        if self.terminado == "0":
            if seleccion == self.correcta[self.numeroR]:
                requests.post("http://127.0.0.1:4567/SumarPuntos", headers = {'Content-type': 'application/json'}, data = str(arrayPartida))
                self.pantallaDeJuego.destroy()
                self.partida()
                self.pantallaDeJuego.pack()
                pass
            else:
                requests.post("http://127.0.0.1:4567/quitarPuntos", headers = {'Content-type': 'application/json'}, data = str(arrayPartida))
                self.pantallaDeJuego.destroy()
                self.partida()
                self.pantallaDeJuego.pack()
                pass
            pass
        else:
            self.pantallaDeJuego.destroy()
            self.resultadoP()
            self.pantallaDeResultado.pack()
            pass



    def VolverAJugar(self):
        self.pantallaDeResultado.destroy()
        self.idPartidaActualSTR = (requests.post("http://127.0.0.1:4567/agregarGame", headers = {'Content-type': 'application/json'}, data = '{"player1_id": %s, "player2_id": %s }' % (self.idLogueado, self.jugador2))).text
        self.idPartidaActual = int(self.idPartidaActualSTR) - 1
        self.partida()
        self.pantallaDeJuego.pack()

        pass

    def VolverAlMenu(self):
        self.pantallaDeResultado.destroy()
        self.menu()
        self.pantallaPrincipal.pack()
        pass

    def irAPartidasSinTemrinar(self):
        self.pantallaPrincipal.destroy()
        self.partidasSinTerminar()
        self.pantallaPartidas.pack()
        pass



















root = Tk()
app = App(root)


mainloop() 