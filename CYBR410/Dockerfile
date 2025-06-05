FROM ubuntu:latest

WORKDIR /home/ubuntu

# Install Python, pip, venv, and other dependencies
RUN apt update && apt install -y python3 python3-pip python3-venv

# Set up Python virtual environment and install Flask + Gunicorn
RUN python3 -m venv venv
RUN /home/ubuntu/venv/bin/pip install --upgrade pip
RUN /home/ubuntu/venv/bin/pip install flask gunicorn

# Set the PATH to use virtualenv binaries
ENV PATH="/home/ubuntu/venv/bin:$PATH"

# Copy app files into the container
COPY app.py .
COPY static ./static
COPY templates ./templates

# Expose Flask port
EXPOSE 5000

# Run with Gunicorn in production
CMD ["gunicorn", "-b", "0.0.0.0:5000", "app:app"]

