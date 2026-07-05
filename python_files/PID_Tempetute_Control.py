import mathplotlib.pyplot as plt
import numpy as np
from flask import Flask, render_template, flash, redirect, url_for, request, jsonify



app=Flask(__name__)

@app.route("/")
def index(method=["GET", "POST"]):
    y=np.array([])


if __name__=="__main__":
    app.debug(True)
