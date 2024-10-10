from flask import Flask, request, jsonify
import logging

app = Flask(__name__)

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

@app.route('/read_file', methods=['GET'])
def read_file():
    content = ''
    try:
        with open('nonexistentfile.txt', 'r') as file:
            for chunk in iter(lambda: file.read(4096), ''):
                content += chunk
    except Exception as e:
        logger.error(e, exc_info=True)
        return jsonify({"error": "Error reading file"}), 500

@app.route('/string_concat', methods=['GET'])
def string_concat():
    logger.info("hello " + nonexistentvariable)

if __name__ == '__main__':
    app.run(host='0.0.0.0', port='9090')
